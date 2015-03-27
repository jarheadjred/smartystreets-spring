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
public class AddressResponse {

    @Length(max = 50)
    @JsonProperty("input_id")
    private String inputId;
    @JsonProperty("input_index")
    private int inputIndex;
    @JsonProperty("candidate_index")
    private int candidateIndex;
    @Length(max = 50)
    private String addressee;
    @Length(max = 50)
    @JsonProperty("delivery_line_1")
    private String deliveryLine1;
    @Length(max = 50)
    @JsonProperty("delivery_line_2")
    private String deliveryLine2;
    @Length(max = 50)
    @JsonProperty("last_line")
    private String lastLine;
    @Length(max = 12)
    @JsonProperty("delivery_point_barcode")
    private String deliveryPointBarcode;

    private Components components;
    private Metadata metadata;
    private Analysis analysis;


    public String getAddressee() {

        return addressee;
    }

    public void setAddressee(String addressee) {

        this.addressee = addressee;
    }

    public int getCandidateIndex() {

        return candidateIndex;
    }

    public void setCandidateIndex(int candidateIndex) {

        this.candidateIndex = candidateIndex;
    }

    public String getDeliveryLine1() {

        return deliveryLine1;
    }

    public void setDeliveryLine1(String deliveryLine1) {

        this.deliveryLine1 = deliveryLine1;
    }

    public String getDeliveryLine2() {

        return deliveryLine2;
    }

    public void setDeliveryLine2(String deliveryLine2) {

        this.deliveryLine2 = deliveryLine2;
    }

    public String getDeliveryPointBarcode() {

        return deliveryPointBarcode;
    }

    public void setDeliveryPointBarcode(String deliveryPointBarcode) {

        this.deliveryPointBarcode = deliveryPointBarcode;
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

    public String getLastLine() {

        return lastLine;
    }

    public void setLastLine(String lastLine) {

        this.lastLine = lastLine;
    }

    public Analysis getAnalysis() {

        return analysis;
    }

    public void setAnalysis(Analysis analysis) {

        this.analysis = analysis;
    }

    public Components getComponents() {

        return components;
    }

    public void setComponents(Components components) {

        this.components = components;
    }

    public Metadata getMetadata() {

        return metadata;
    }

    public void setMetadata(Metadata metadata) {

        this.metadata = metadata;
    }
}
