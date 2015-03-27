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

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SmartyStreetsAPITest {

    SmartyStreetsAPI api;

    @Before
    public void setup() {

        api = new SmartyStreetsAPI();
        api.apiUri = "https://api.smartystreets.com";
        api.apiToken = "<insert your own>";
        api.authId = "<insert your own>";
        api.streetAddressPath = "/street-address";
        api.zipCodePath = "/zipcode";
    }

    @Test @Ignore
    public void canSerializeResponse() {

        Address apiAddress = new Address();
        apiAddress.setInputId("1");
        apiAddress.setAddressee("Dev Developer");
        apiAddress.setStreet("3569 Cohansey Street");
        apiAddress.setCity("Shoreview");
        apiAddress.setState("MN");
        apiAddress.setZipCode("55126");

        AddressResponse[] addressResponses = api.streetAddress(apiAddress);
        System.out.println(addressResponses);
    }
}