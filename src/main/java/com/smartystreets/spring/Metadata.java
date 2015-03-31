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
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Metadata {

    @JsonProperty("record_type")
    private RecordType recordType;
    @JsonProperty("zip_type")
    private ZipType zipType = ZipType.Standard;
    @JsonProperty("county_fips")
    @Length(max = 5)
    private String countyFips;
    @JsonProperty("county_name")
    @Length(max = 64)
    private String countyName;
    @JsonProperty("carrier_route")
    @Length(max = 4)
    private String carrierRoute;
    @JsonProperty("congressional_district")
    @Length(max = 2)
    private String congressionalDistrict;
    @JsonProperty("building_default_indicator")
    @Length(max = 1)
    private String buildingDefaultIndicator;
    private ResidentialDeliveryIndicator rdi = ResidentialDeliveryIndicator.Unknown;
    @JsonProperty("elot_sequence")
    @Length(max = 4)
    private String elotSequence;
    @JsonProperty("elot_sort")
    @Length(max = 4)
    private ElotSortType elotSort;
    @JsonUnwrapped
    private Location location;
    @JsonUnwrapped
    private TimeInfo timeInfo;

    public String getBuildingDefaultIndicator() {

        return buildingDefaultIndicator;
    }

    public void setBuildingDefaultIndicator(String buildingDefaultIndicator) {

        this.buildingDefaultIndicator = buildingDefaultIndicator;
    }

    public String getCarrierRoute() {

        return carrierRoute;
    }

    public void setCarrierRoute(String carrierRoute) {

        this.carrierRoute = carrierRoute;
    }

    public String getCongressionalDistrict() {

        return congressionalDistrict;
    }

    public void setCongressionalDistrict(String congressionalDistrict) {

        this.congressionalDistrict = congressionalDistrict;
    }

    public String getCountyFips() {

        return countyFips;
    }

    public void setCountyFips(String countyFips) {

        this.countyFips = countyFips;
    }

    public String getCountyName() {

        return countyName;
    }

    public void setCountyName(String countyName) {

        this.countyName = countyName;
    }

    public String getElotSequence() {

        return elotSequence;
    }

    public void setElotSequence(String elotSequence) {

        this.elotSequence = elotSequence;
    }

    public ElotSortType getElotSort() {

        return elotSort;
    }

    public void setElotSort(ElotSortType elotSort) {

        this.elotSort = elotSort;
    }

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {

        this.location = location;
    }

    public ResidentialDeliveryIndicator getRdi() {

        return rdi;
    }

    public void setRdi(ResidentialDeliveryIndicator rdi) {

        this.rdi = rdi;
    }

    public RecordType getRecordType() {

        return recordType;
    }

    public void setRecordType(RecordType recordType) {

        this.recordType = recordType;
    }

    public TimeInfo getTimeInfo() {

        return timeInfo;
    }

    public void setTimeInfo(TimeInfo timeInfo) {

        this.timeInfo = timeInfo;
    }

    public ZipType getZipType() {

        return zipType;
    }

    public void setZipType(ZipType zipType) {

        this.zipType = zipType;
    }
}
