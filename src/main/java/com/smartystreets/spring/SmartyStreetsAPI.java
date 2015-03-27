/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Room & Board
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.smartystreets.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Primary
public class SmartyStreetsAPI {

    private static final String AUTH_ID_KEY = "auth-id";
    private static final String AUTH_TOKEN_KEY = "auth-token";

    @Value("${smartystreets.api.uri}")
    String apiUri;
    @Value("${smartystreets.api.path.streetaddress}")
    String streetAddressPath;
    @Value("${smartystreets.api.path.zipcode}")
    String zipCodePath;

    @Value("${smartystreets.api.token}")
    String apiToken;
    @Value("${smartystreets.api.authid}")
    String authId;

    public ZipCodeResponse[] zipCode(String zipCode, String city, String state, String inputId) {

        URI uri = createURI(zipCodePath);

        HttpEntity<ZipCodeResponse[]> response = new RestTemplate()
                .postForEntity(uri, new ZipCodeRequest[]{ new ZipCodeRequest(city, state, zipCode, inputId) }, ZipCodeResponse[].class);

        return response.getBody();
    }

    public AddressResponse[] streetAddress(Address address) {

        URI uri = createURI(streetAddressPath);

        return new RestTemplate().postForObject(uri, new Address[]{address}, AddressResponse[].class);
    }

    private URI createURI(String path) {

        return UriComponentsBuilder.fromUriString(apiUri)
                .path(path)
                .queryParam(AUTH_ID_KEY, authId)
                .queryParam(AUTH_TOKEN_KEY, apiToken)
                .build()
                .toUri();
    }

}