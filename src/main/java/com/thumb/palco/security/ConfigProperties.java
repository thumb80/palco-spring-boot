package com.thumb.palco.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {

    private static ConfigProperties instance;

    public ConfigProperties() {

    }

    static {
        try {
            instance = new ConfigProperties();
        } catch (Exception e) {
            throw new RuntimeException("Exception during creating singleton instance");
        }
    }

    private String authToken;

    public String getAuthToken() {
        return instance.authToken;
    }

    public void setAuthToken(String authToken) {
        instance.authToken = authToken;
    }

    public static ConfigProperties getInstance() {
        return instance;
    }
}
