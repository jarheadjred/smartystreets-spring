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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SmartyStreetsAPIDataTransformTest {


    @Test
    public void canTransformAddressResponse() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("address_response.json").getFile());

        ObjectMapper om = new ObjectMapper();
        AddressResponse addressResponse = om.readValue(file, AddressResponse[].class)[0];

        assertEquals(0, addressResponse.getInputIndex());
        assertEquals(0, addressResponse.getCandidateIndex());
        assertEquals("13936 Flay Ave N", addressResponse.getDeliveryLine1());
        assertEquals("Hugo MN 55038-6401", addressResponse.getLastLine());
        assertEquals("550386401369", addressResponse.getDeliveryPointBarcode());

        Components components = addressResponse.getComponents();
        assertEquals("13936", components.getPrimaryNumber());
        assertEquals("Flay", components.getStreetName());
        assertEquals("N", components.getStreetPostdirection());
        assertEquals("Ave", components.getStreetSuffix());
        assertEquals("Hugo", components.getCityName());
        assertEquals("MN", components.getStateAbbreviation());
        assertEquals("55038", components.getZipcode());
        assertEquals("6401", components.getPlus4Code());
        assertEquals("36", components.getDeliveryPoint());
        assertEquals("9", components.getDeliveryPointCheckDigit());

        Metadata metadata = addressResponse.getMetadata();
        assertEquals(RecordType.S, metadata.getRecordType());
        assertEquals(ZipType.Standard, metadata.getZipType());
        assertEquals("27163", metadata.getCountyFips());
        assertEquals("Washington", metadata.getCountyName());
        assertEquals("R009", metadata.getCarrierRoute());
        assertEquals("06", metadata.getCongressionalDistrict());
        assertEquals(ResidentialDeliveryIndicator.Residential, metadata.getRdi());
        assertEquals("0238", metadata.getElotSequence());
        assertEquals(ElotSortType.A, metadata.getElotSort());
        assertEquals(BigDecimal.valueOf(45.15118D), metadata.getLocation().getLatitude());
        assertEquals(BigDecimal.valueOf(-92.99295D), metadata.getLocation().getLongitude());
        assertEquals("Zip9", metadata.getLocation().getPrecision());
        assertEquals("Central", metadata.getTimeInfo().getTimeZone());
        assertEquals(BigDecimal.valueOf(-6), metadata.getTimeInfo().getUtcOffset());
        assertEquals(true, metadata.getTimeInfo().isDst());

        Analysis analysis = addressResponse.getAnalysis();
        assertEquals(DeliveryPointValidationType.Y, analysis.getDeliveryPointValidationType());
        assertEquals("AABB", analysis.getDpvFootnotes());
        assertEquals("N", analysis.getDpvCmra());
        assertEquals("N", analysis.getDpvVacant());
        assertEquals("Y", analysis.getActive());
        assertEquals("N#", analysis.getFootnotes());
    }


}
