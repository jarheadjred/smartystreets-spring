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
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Address {

    @JsonProperty(value = "input_id")
    @Length(max = 16)
    private String inputId;
    @Length(max = 64)
    private String street;
    @Length(max = 64)
    private String stree2;
    @Length(max = 32)
    private String secondary;
    @Length(max = 64)
    private String city;
    @Length(max = 32)
    private String state;
    @Length(max = 16)
    @JsonProperty(value = "zipcode")
    private String zipCode;
    @Length(max = 64)
    @JsonProperty(value = "lastline")
    private String lastLine;
    @Length(max = 64)
    private String addressee;
    @Length(max = 64)
    private String urbanization;
    @Max(10)
    private Integer candidates;


    public String getAddressee() {

        return addressee;
    }

    public void setAddressee(String addressee) {

        this.addressee = addressee;
    }

    public Integer getCandidates() {

        return candidates;
    }

    public void setCandidates(Integer candidates) {

        this.candidates = candidates;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getInputId() {

        return inputId;
    }

    public void setInputId(String inputId) {

        this.inputId = inputId;
    }

    public String getLastLine() {

        return lastLine;
    }

    public void setLastLine(String lastLine) {

        this.lastLine = lastLine;
    }

    public String getSecondary() {

        return secondary;
    }

    public void setSecondary(String secondary) {

        this.secondary = secondary;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }

    public String getStree2() {

        return stree2;
    }

    public void setStree2(String stree2) {

        this.stree2 = stree2;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public String getUrbanization() {

        return urbanization;
    }

    public void setUrbanization(String urbanization) {

        this.urbanization = urbanization;
    }

    public String getZipCode() {

        return zipCode;
    }

    public void setZipCode(String zipCode) {

        this.zipCode = zipCode;
    }
}
