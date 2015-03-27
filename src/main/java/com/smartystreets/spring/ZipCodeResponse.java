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

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ZipCodeResponse {

    @JsonProperty("input_index")
    private int inputIndex;
    @JsonProperty("input_id")
    private String inputId;
    @JsonProperty("city_states")
    private List<CityState> cityStates;
    @JsonProperty("zipcodes")
    private List<ZipCode> zipCodes;
    private String status;
    private String reason;

    public List<CityState> getCityStates() {

        return cityStates;
    }

    public void setCityStates(List<CityState> cityStates) {

        this.cityStates = cityStates;
    }

    public String getInputId() {

        return inputId;
    }

    public void setInputId(String inputId) {

        this.inputId = inputId;
    }

    public int getInputIndex() {

        return inputIndex;
    }

    public void setInputIndex(int inputIndex) {

        this.inputIndex = inputIndex;
    }

    public String getReason() {

        return reason;
    }

    public void setReason(String reason) {

        this.reason = reason;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public List<ZipCode> getZipCodes() {

        return zipCodes;
    }

    public void setZipCodes(List<ZipCode> zipCodes) {

        this.zipCodes = zipCodes;
    }
}
