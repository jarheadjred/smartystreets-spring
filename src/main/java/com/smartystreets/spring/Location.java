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

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

/**
 * Indicates the precision of the latitude &amp; longitude values.
 * <br><br>
 * <b>Unknown</b> — Coordinates not known, possibly because address is invalid<br>
 * <b>None</b> — Coordinates are not provided for this address. Military addresses
 * such as APO, FPO, and DPO do not provide coordinates.<br>
 * <b>State</b> — Reserved for future use<br>
 * <b>SolutionArea</b> — Reserved for future use<br>
 * <b>City</b> — Reserved for future use<br>
 * <b>Zip5</b> — Accurate to a 5-digit ZIP Code level (least precise)<br>
 * <b>Zip6</b> — Accurate to a 6-digit ZIP Code level<br>
 * <b>Zip7</b> — Accurate to a 7-digit ZIP Code level<br>
 * <b>Zip8</b> — Accurate to a 8-digit ZIP Code level<br>
 * <b>Zip9</b> — Accurate to a 9-digit ZIP Code level (most precise but NOT <a href="/kb/faq/how-accurate-is-your-geocoding-data">rooftop level)</a><br>
 * <b>Structure</b> — Reserved for future use<br><br>
 * (note: addresses for which the ZIP9 precision is not available, the ZIP# precision in interpolated based on neighboring addresses.  Thus, ZIP7 is an average of all the lat/lon coordinates of nearby ZIP codes that share those first 7 digits<br>
 */
public class Location {

    private BigDecimal latitude;
    private BigDecimal longitude;

    @Length(max = 18)
    private String precision;

    public BigDecimal getLatitude() {

        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {

        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {

        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {

        this.longitude = longitude;
    }

    public String getPrecision() {

        return precision;
    }

    public void setPrecision(String precision) {

        this.precision = precision;
    }
}
