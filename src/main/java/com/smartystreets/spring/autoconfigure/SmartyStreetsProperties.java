package com.smartystreets.spring.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Optional;

import static java.util.Optional.of;

@ConfigurationProperties(prefix = "smartystreets.api")
public class SmartyStreetsProperties {


    String streetaddressUrl = "https://api.smartystreets.com/street-address";
    String zipcodeUrl = "https://us-zipcode.api.smartystreets.com/lookup";
    String statusUrl = "https://us-street.api.smartystreets.com/";

    String token;
    String authid;

    Optional<String> includeinvalid = of("true");
    Optional<String> standardizeonlyvalue = of("false");

    int readTimeout = -1;
    int connectionTimeout = -1;

    private boolean enableStatusResponseValidation = true;
    private String statusResponse = "us-street-api:OK";

    public String getStreetaddressUrl() {

        return streetaddressUrl;
    }

    public void setStreetaddressUrl(String streetaddressUrl) {

        this.streetaddressUrl = streetaddressUrl;
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

    public boolean enableStatusResponseValidation() {

        return enableStatusResponseValidation;
    }

    public boolean isEnableStatusResponseValidation() {

        return enableStatusResponseValidation;
    }

    public String getStatusResponse() {

        return statusResponse;
    }

    public void setStatusResponse(String statusResponse) {

        this.statusResponse = statusResponse;
    }
}
