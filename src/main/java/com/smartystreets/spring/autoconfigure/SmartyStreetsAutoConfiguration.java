package com.smartystreets.spring.autoconfigure;

import com.smartystreets.spring.SmartyStreetsAPI;
import org.springframework.beans.factory.annotation.Autowired;
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

            api.setApiUri(properties.getUri());
            api.setStreetAddressPath(properties.getStreetaddress());
            api.setZipCodePath(properties.getZipcode());

            return api;
        }
    }
}
