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

public enum RecordType {
    /**
     * Firm; the finest level of match available for an address
     */
    F("Firm"),
    /**
     * General Delivery; for mail to be held at local post offices
     */
    G("General Delivery"),
    /**
     * high-rise; address contains apartment or building sub-units
     */
    H("high-rise"),
    /**
     * Post Office box; address is a PO Box record type
     */
    P("Post Office box"),
    /**
     * Rural Route or Highway Contract; may have box number ranges
     */
    R("Rural Route or Highway Contract"),
    /**
     * Street; address contains a valid primary number range
     */
    S("Street");

    private final String description;

    private RecordType(String description) {

        this.description = description;
    }

    public String description() {

        return description;
    }
}
