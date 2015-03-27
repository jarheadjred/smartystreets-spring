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

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Components {

    @Length(max = 64)
    private String urbanization;
    @Length(max = 30)
    @JsonProperty("primary_number")
    private String primaryNumber;
    @Length(max=64)
    @JsonProperty("street_name")
    private String streetName;
    @Length(max=16)
    @JsonProperty("street_predirection")
    private String streetPredirection;
    @Length(max=16)
    @JsonProperty("street_suffix")
    private String streetSuffix;
    @Length(max=32)
    @JsonProperty("secondary_number")
    private String secondaryNumber;
    @Length(max=16)
    @JsonProperty("secondary_designator")
    private String secondaryDesignator;
    @Length(max=32)
    @JsonProperty("extra_secondary_number")
    private String extraSecondaryNumber;
    @Length(max=16)
    @JsonProperty("pmb_designator")
    private String pmbDesignator;
    @Length(max=16)
    @JsonProperty("pmb_number")
    private String pmbNumber;
    @Length(max=64)
    @JsonProperty("city_name")
    private String cityName;
    @Length(max=64)
    @JsonProperty("default_city_name")
    private String defaultCityName;
    @Length(max=2)
    @JsonProperty("state_abbreviation")
    private String stateAbbreviation;
    @Length(max=5)
    private String zipcode;
    @Length(max=4)
    @JsonProperty("plus4_code")
    private String plus4Code;
    @Length(max=2)
    @JsonProperty("delivery_point")
    private String deliveryPoint;
    @Length(max=1)
    @JsonProperty("delivery_point_check_digit")
    private String deliveryPointCheckDigit;


    public String getExtraSecondaryNumber() {

        return extraSecondaryNumber;
    }

    public void setExtraSecondaryNumber(String extraSecondaryNumber) {

        this.extraSecondaryNumber = extraSecondaryNumber;
    }

    public String getPmbDesignator() {

        return pmbDesignator;
    }

    public void setPmbDesignator(String pmbDesignator) {

        this.pmbDesignator = pmbDesignator;
    }

    public String getPrimaryNumber() {

        return primaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {

        this.primaryNumber = primaryNumber;
    }

    public String getSecondaryDesignator() {

        return secondaryDesignator;
    }

    public void setSecondaryDesignator(String secondaryDesignator) {

        this.secondaryDesignator = secondaryDesignator;
    }

    public String getSecondaryNumber() {

        return secondaryNumber;
    }

    public void setSecondaryNumber(String secondaryNumber) {

        this.secondaryNumber = secondaryNumber;
    }

    public String getStreetName() {

        return streetName;
    }

    public void setStreetName(String streetName) {

        this.streetName = streetName;
    }

    public String getStreetPredirection() {

        return streetPredirection;
    }

    public void setStreetPredirection(String streetPredirection) {

        this.streetPredirection = streetPredirection;
    }

    public String getStreetSuffix() {

        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {

        this.streetSuffix = streetSuffix;
    }

    public String getUrbanization() {

        return urbanization;
    }

    public void setUrbanization(String urbanization) {

        this.urbanization = urbanization;
    }

    public String getCityName() {

        return cityName;
    }

    public void setCityName(String cityName) {

        this.cityName = cityName;
    }

    public String getDefaultCityName() {

        return defaultCityName;
    }

    public void setDefaultCityName(String defaultCityName) {

        this.defaultCityName = defaultCityName;
    }

    public String getDeliveryPoint() {

        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {

        this.deliveryPoint = deliveryPoint;
    }

    public String getDeliveryPointCheckDigit() {

        return deliveryPointCheckDigit;
    }

    public void setDeliveryPointCheckDigit(String deliveryPointCheckDigit) {

        this.deliveryPointCheckDigit = deliveryPointCheckDigit;
    }

    public String getPlus4Code() {

        return plus4Code;
    }

    public void setPlus4Code(String plus4Code) {

        this.plus4Code = plus4Code;
    }

    public String getPmbNumber() {

        return pmbNumber;
    }

    public void setPmbNumber(String pmbNumber) {

        this.pmbNumber = pmbNumber;
    }

    public String getStateAbbreviation() {

        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {

        this.stateAbbreviation = stateAbbreviation;
    }

    public String getZipcode() {

        return zipcode;
    }

    public void setZipcode(String zipcode) {

        this.zipcode = zipcode;
    }
}
