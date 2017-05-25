package com.smartystreets.spring.autoconfigure;

import com.smartystreets.spring.SmartyStreetsAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class SmartyStreetsAutoConfiguration {

    @Bean(name = "com.smartystreets.spring.autoconfigure.SmartyStreetsProperties")
    @ConditionalOnMissingBean
    public SmartyStreetsProperties smartyStreetsProperties() {
        return new SmartyStreetsProperties();
    }

    @Configuration
    protected static class SmartyStreetsConfiguration {

        @Autowired
        protected SmartyStreetsProperties properties;

        @Bean
        @ConditionalOnMissingBean
        public SmartyStreetsAPI smartyStreetsAPI() {

            SmartyStreetsAPI api = new SmartyStreetsAPI();

            api.setAuthId(properties.getAuthid());
            api.setApiToken(properties.getToken());

            api.setIncludeInvalidValue(properties.getIncludeinvalid());
            api.setStandardizeOnlyValue(properties.getStandardizeonlyvalue());

            api.setReadTimeout(properties.getReadTimeout());
            api.setConnectionTimeout(properties.getConnectionTimeout());

            api.setStreetAddressUrl(properties.getStreetAddressUrl());
            api.setZipCodeUrl(properties.getZipcodeUrl());
            api.setStatusUrl(properties.getStatusUrl());

            return api;
        }

        @Bean
        @ConditionalOnEnabledHealthIndicator("smartystreets")
        @ConditionalOnMissingBean(name = "smartyStreetsHealthIndicator")
        public SmartyStreetsHealthIndicator smartyStreetsHealthIndicator(SmartyStreetsAPI api, SmartyStreetsProperties properties) {

            return new SmartyStreetsHealthIndicator(api, properties);
        }
    }
}
