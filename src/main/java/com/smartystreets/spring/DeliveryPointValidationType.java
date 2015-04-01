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

public enum DeliveryPointValidationType {

	Y, /**
		— Confirmed; entire address was DPV confirmed deliverable.
			(eg. 1600 Amphitheatre Pkwy Mountain View, CA)
		*/
	N, /** 
		— Not Confirmed; address could not be DPV confirmed as deliverable. (only returned as part of the XML response)
		*/
	S, /**
	 	— Confirmed By Dropping Secondary; address was DPV confirmed by dropping secondary info (apartment, suite, etc).
			(eg. 62 Ea Darden Dr Apt 298 Anniston, AL)
	 	*/
	D, /**
		— Confirmed - Missing Secondary Info; The address was DPV confirmed, but it is missing secondary information (apartment, suite, etc).
			(eg. 122 Mast Rd Lee, NH),
		*/
	blank
}
