package com.smartystreets.spring.autoconfigure;

import com.smartystreets.spring.SmartyStreetsAPI;
import org.junit.Test;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class SmartyStreetsAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @Test
    public void testDefaultSmartyStreetsConfiguration() {

        this.context = new AnnotationConfigApplicationContext();
        this.context.register(SmartyStreetsAutoConfiguration.class,
                PropertyPlaceholderAutoConfiguration.class);

        this.context.refresh();
        assertNotNull(this.context.getBean("smartyStreetsAPI"));
    }

    @Test
    public void testOverrideApiConfiguration() throws Exception {

        this.context = new AnnotationConfigApplicationContext();
        EnvironmentTestUtils.addEnvironment(this.context, "smartystreets.api.token:foo");
        EnvironmentTestUtils.addEnvironment(this.context, "smartystreets.api.authid:bar");
        this.context.register(SmartyStreetsAutoConfiguration.class,
                PropertyPlaceholderAutoConfiguration.class);
        this.context.refresh();
        assertEquals("foo", this.context.getBean(SmartyStreetsAPI.class).getApiToken());
        assertEquals("bar", this.context.getBean(SmartyStreetsAPI.class).getAuthId());
    }
}