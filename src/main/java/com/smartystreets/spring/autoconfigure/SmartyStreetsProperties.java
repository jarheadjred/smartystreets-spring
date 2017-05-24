package com.smartystreets.spring.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Optional;

import static java.util.Optional.of;

@ConfigurationProperties(prefix = "smartystreets.api")
public class SmartyStreetsProperties {


    private String streetAddressUrl = "https://api.smartystreets.com/street-address";
    private String zipcodeUrl = "https://us-zipcode.api.smartystreets.com/lookup";
    private String statusUrl = "https://us-street.api.smartystreets.com/";

    private String token;
    private String authid;

    private Optional<String> includeinvalid = of("true");
    private Optional<String> standardizeonlyvalue = of("false");

    private int readTimeout = -1;
    private int connectionTimeout = -1;

    private boolean enableStatusResponseValidation = true;
    private String requiredStatusResponse = "us-street-api:OK";

    public String getStreetAddressUrl() {

        return streetAddressUrl;
    }

    public void setStreetAddressUrl(String streetAddressUrl) {

        this.streetAddressUrl = streetAddressUrl;
    }

    public String getZipcodeUrl() {

        return zipcodeUrl;
    }

    public void setZipcodeUrl(String zipcodeUrl) {

        this.zipcodeUrl = zipcodeUrl;
    }

    public String getStatusUrl() {

        return statusUrl;
    }

    public void setStatusUrl(String statusUrl) {

        this.statusUrl = statusUrl;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {

        this.token = token;
    }

    public String getAuthid() {

        return authid;
    }

    public void setAuthid(String authid) {

        this.authid = authid;
    }

    public Optional<String> getIncludeinvalid() {

        return includeinvalid;
    }

    public void setIncludeinvalid(Optional<String> includeinvalid) {

        this.includeinvalid = includeinvalid;
    }

    public Optional<String> getStandardizeonlyvalue() {

        return standardizeonlyvalue;
    }

    public void setStandardizeonlyvalue(Optional<String> standardizeonlyvalue) {

        this.standardizeonlyvalue = standardizeonlyvalue;
    }

    public int getReadTimeout() {

        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {

        this.readTimeout = readTimeout;
    }

    public int getConnectionTimeout() {

        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {

        this.connectionTimeout = connectionTimeout;
    }

    public boolean isEnableStatusResponseValidation() {

        return enableStatusResponseValidation;
    }

    public void setEnableStatusResponseValidation(boolean enableStatusResponseValidation) {

        this.enableStatusResponseValidation = enableStatusResponseValidation;
    }

    public String getRequiredStatusResponse() {

        return requiredStatusResponse;
    }

    public void setRequiredStatusResponse(String requiredStatusResponse) {

        this.requiredStatusResponse = requiredStatusResponse;
    }
}
