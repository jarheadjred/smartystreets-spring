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
    private final String requiredStatusResponse;

    public SmartyStreetsHealthIndicator(SmartyStreetsAPI api, SmartyStreetsProperties properties) {

        this.api = api;
        this.enableStatusResponseValidation = properties.isEnableStatusResponseValidation();
        this.requiredStatusResponse = properties.getRequiredStatusResponse().trim();
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        ResponseEntity<String> status = api.status();
        validateStatus(status, builder);
    }

    private void validateStatus(ResponseEntity<String> status, Health.Builder builder) {

        if (status == null) {
            LOGGER.warn(format("SmartyStreets status response not received."));
            builder.down();
            return;
        }
        validateStatusCode(status, builder);
    }

    private void validateStatusCode(ResponseEntity<String> status, Health.Builder builder) {

        HttpStatus statusCode = status.getStatusCode();
        if (statusCode != HttpStatus.OK) {
            LOGGER.warn(format("SmartyStreets status response code: %s", statusCode));
            builder.down();
            return;
        }
        builder.up(); //potentially overwritten later
        validateStatusResponse(status, builder);
    }

    private void validateStatusResponse(ResponseEntity<String> status, Health.Builder builder) {

        if (!enableStatusResponseValidation) {
            return;
        }
        String body = status.getBody().trim();
        if (!requiredStatusResponse.equals(body)) {
            LOGGER.warn(format("SmartyStreets status response: %s but expected %s", body, requiredStatusResponse));
            builder.down();
            builder.withDetail("response", body).withDetail("expectedResponse", requiredStatusResponse);
        }
    }
}