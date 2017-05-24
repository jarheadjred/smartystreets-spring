package com.smartystreets.spring.autoconfigure;

import com.smartystreets.spring.SmartyStreetsAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.lang.String.format;

public class SmartyStreetsHealthIndicator extends AbstractHealthIndicator {

    private static final Log LOGGER = LogFactory.getLog(SmartyStreetsHealthIndicator.class);

    private final SmartyStreetsAPI api;
    private final boolean enableStatusResponseValidation;
    private final String expectedStatusResponse;

    public SmartyStreetsHealthIndicator(SmartyStreetsAPI api, SmartyStreetsProperties properties) {

        this.api = api;
        this.enableStatusResponseValidation = properties.enableStatusResponseValidation();
        this.expectedStatusResponse = properties.getStatusResponse();
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        ResponseEntity<String> status = api.status();
        if (status != null) {
            HttpStatus statusCode = status.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                if (enableStatusResponseValidation) {
                    String body = status.getBody();
                    if (expectedStatusResponse.equals(body.trim())) {
                        builder.up();
                    } else {
                        LOGGER.warn(format("SmartyStreets status response: %s but expected %s", body, expectedStatusResponse));
                        builder.down();
//                        builder.withDetail("response", body).withDetail("expectedResponse", expectedStatusResponse);
                    }
                } else {
                    builder.up();
                }
            } else {
                LOGGER.warn(format("SmartyStreets status response code: %s", statusCode));
                builder.down();
            }
        } else {
            LOGGER.warn(format("SmartyStreets status response not received."));
            builder.down();
        }
    }
}