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

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Analysis {

    @JsonProperty("dpv_match_code")
    private String dpvMatchCode;
    @JsonProperty("dpv_footnotes")
    private String dpvFootnotes;
    @JsonProperty("dpv_cmra")
    private String dpvCmra;
    @JsonProperty("dpv_vacant")
    private String dpvVacant;
    @JsonProperty("active")
    private String active;

    /**
     * @return The dpvMatchCode
     */
    @JsonProperty("dpv_match_code")
    public String getDpvMatchCode() {

        return dpvMatchCode;
    }

    /**
     * @param dpvMatchCode The dpv_match_code
     */
    @JsonProperty("dpv_match_code")
    public void setDpvMatchCode(String dpvMatchCode) {

        this.dpvMatchCode = dpvMatchCode;
    }

    /**
     * @return The dpvFootnotes
     */
    @JsonProperty("dpv_footnotes")
    public String getDpvFootnotes() {

        return dpvFootnotes;
    }

    /**
     * @param dpvFootnotes The dpv_footnotes
     */
    @JsonProperty("dpv_footnotes")
    public void setDpvFootnotes(String dpvFootnotes) {

        this.dpvFootnotes = dpvFootnotes;
    }

    /**
     * @return The dpvCmra
     */
    @JsonProperty("dpv_cmra")
    public String getDpvCmra() {

        return dpvCmra;
    }

    /**
     * @param dpvCmra The dpv_cmra
     */
    @JsonProperty("dpv_cmra")
    public void setDpvCmra(String dpvCmra) {

        this.dpvCmra = dpvCmra;
    }

    /**
     * @return The dpvVacant
     */
    @JsonProperty("dpv_vacant")
    public String getDpvVacant() {

        return dpvVacant;
    }

    /**
     * @param dpvVacant The dpv_vacant
     */
    @JsonProperty("dpv_vacant")
    public void setDpvVacant(String dpvVacant) {

        this.dpvVacant = dpvVacant;
    }

    /**
     * @return The active
     */
    @JsonProperty("active")
    public String getActive() {

        return active;
    }

    /**
     * @param active The active
     */
    @JsonProperty("active")
    public void setActive(String active) {

        this.active = active;
    }

}
