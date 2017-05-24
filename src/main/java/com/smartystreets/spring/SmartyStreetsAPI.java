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

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SmartyStreetsAPI {

    private static final String AUTH_ID_KEY = "auth-id";
    private static final String AUTH_TOKEN_KEY = "auth-token";
    private static final String INCLUDE_INVALID_HEADER = "X-Include-Invalid";
    private static final String STANDARDIZE_ONLY_HEADER = "X-Standardize-Only";

    private String zipCodeUrl;
    private String streetAddressUrl;
    private String statusUrl;
    private String authId;
    private String apiToken;
    private Optional<String> includeInvalidValue = Optional.empty();
    private Optional<String> standardizeOnlyValue = Optional.empty();
    private int readTimeout;
    private int connectionTimeout;

    public ZipCodeResponse[] zipCode(String zipCode, String city, String state, String inputId) {

        URI uri = createURI(zipCodeUrl);
        HttpEntity<ZipCodeResponse[]> response = getRestTemplate().postForEntity(uri, new ZipCodeRequest[]{new ZipCodeRequest(city, state, zipCode, inputId)}, ZipCodeResponse[].class);
        return response.getBody();
    }

    public AddressResponse[] streetAddress(Address address) {

        URI uri = createURI(streetAddressUrl);
        return getRestTemplate().postForObject(uri, new Address[]{address}, AddressResponse[].class);
    }

    public ResponseEntity<String> status() {

        URI uri = createURI(statusUrl);
        return getRestTemplate().getForEntity(uri, String.class);
    }

    private URI createURI(String uri) {

        return UriComponentsBuilder.fromUriString(uri)
                .queryParam(AUTH_ID_KEY, authId)
                .queryParam(AUTH_TOKEN_KEY, apiToken)
                .build()
                .toUri();
    }

    RestTemplate getRestTemplate() {

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        includeInvalidValue.ifPresent(val -> interceptors.add(new HeaderRequestInterceptor(INCLUDE_INVALID_HEADER, val)));
        standardizeOnlyValue.ifPresent(val -> interceptors.add(new HeaderRequestInterceptor(STANDARDIZE_ONLY_HEADER, val)));

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(readTimeout);
        factory.setConnectTimeout(connectionTimeout);

        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }

    public void setZipCodeUrl(String zipCodeUrl) {

        this.zipCodeUrl = zipCodeUrl;
    }

    public void setStreetAddressUrl(String streetAddressUrl) {

        this.streetAddressUrl = streetAddressUrl;
    }

    public void setStatusUrl(String statusUrl) {

        this.statusUrl = statusUrl;
    }

    public void setIncludeInvalidValue(Optional<String> includeInvalidValue) {

        this.includeInvalidValue = includeInvalidValue;
    }

    public void setStandardizeOnlyValue(Optional<String> standardizeOnlyValue) {

        this.standardizeOnlyValue = standardizeOnlyValue;
    }

    public void setReadTimeout(int readTimeout) {

        this.readTimeout = readTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {

        this.connectionTimeout = connectionTimeout;
    }

    public String getApiToken() {

        return apiToken;
    }

    public void setApiToken(String apiToken) {

        this.apiToken = apiToken;
    }

    public String getAuthId() {

        return authId;
    }

    public void setAuthId(String authId) {

        this.authId = authId;
    }

}