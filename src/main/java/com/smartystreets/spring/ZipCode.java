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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
class ZipCode {

    private String zipcode;
    @JsonProperty("zipcode_type")
    private ZipCodeType zipCodeType;
    @JsonProperty("county_fips")
    private String countyFips;
    private String latitude;
    private String longitude;

    public String getCountyFips() {

        return countyFips;
    }

    public void setCountyFips(String countyFips) {

        this.countyFips = countyFips;
    }

    public String getLatitude() {

        return latitude;
    }

    public void setLatitude(String latitude) {

        this.latitude = latitude;
    }

    public String getLongitude() {

        return longitude;
    }

    public void setLongitude(String longitude) {

        this.longitude = longitude;
    }

    public String getZipcode() {

        return zipcode;
    }

    public void setZipcode(String zipcode) {

        this.zipcode = zipcode;
    }

    public ZipCodeType getZipCodeType() {

        return zipCodeType;
    }

    public void setZipCodeType(ZipCodeType zipCodeType) {

        this.zipCodeType = zipCodeType;
    }
}
