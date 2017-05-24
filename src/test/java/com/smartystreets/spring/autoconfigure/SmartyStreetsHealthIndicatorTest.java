package com.smartystreets.spring.autoconfigure;

import com.smartystreets.spring.SmartyStreetsAPI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SmartyStreetsHealthIndicatorTest {

    private SmartyStreetsAPI api;
    private SmartyStreetsProperties properties;

    @Mock private Health.Builder builder;

    @Before
    public void setup() throws Exception {

        api = mock(SmartyStreetsAPI.class);
        properties = new SmartyStreetsProperties();
        when(builder.withDetail(any(String.class), any(String.class))).thenReturn(builder);
    }

    private SmartyStreetsHealthIndicator getHealthIndicator() {
        
        return new SmartyStreetsHealthIndicator(api, properties);
    }
    
    @Test
    public void doHealthCheckDownNoStatus() throws Exception {

        getHealthIndicator().doHealthCheck(builder);
        verify(builder).down();
    }

    @Test
    public void doHealthCheckDownNotHttpOk() throws Exception {

        when(api.status()).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

        getHealthIndicator().doHealthCheck(builder);
        verify(builder).down();
    }

    @Test
    public void doHealthCheckOkNoValidation() throws Exception {

        when(api.status()).thenReturn(new ResponseEntity<>("bad", HttpStatus.OK));
        properties.setEnableStatusResponseValidation(false);

        getHealthIndicator().doHealthCheck(builder);
        verify(builder).up();
    }

    @Test
    public void doHealthCheckDownWithValidation() throws Exception {

        properties.setEnableStatusResponseValidation(true);
        when(api.status()).thenReturn(new ResponseEntity<>("bad", HttpStatus.OK));

        getHealthIndicator().doHealthCheck(builder);
        verify(builder).down();
    }

    @Test
    public void doHealthCheckUpWithValidation() throws Exception {

        properties.setEnableStatusResponseValidation(true);
        when(api.status()).thenReturn(new ResponseEntity<>(properties.getRequiredStatusResponse(), HttpStatus.OK));

        getHealthIndicator().doHealthCheck(builder);
        verify(builder).up();
    }

}