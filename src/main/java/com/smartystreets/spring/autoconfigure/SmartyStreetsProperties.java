package com.smartystreets.spring.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Optional;

import static java.util.Optional.of;

@ConfigurationProperties(prefix = "smartystreets.api")
public class SmartyStreetsProperties {


    String uri = "https://api.smartystreets.com";
    String streetaddress = "/street-address";
    String zipcode = "/zipcode";

    String token;
    String authid;

    Optional<String> includeinvalid = of("true");
    Optional<String> standardizeonlyvalue = of("false");

    int readTimeout = -1;
    int connectionTimeout = -1;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
}
