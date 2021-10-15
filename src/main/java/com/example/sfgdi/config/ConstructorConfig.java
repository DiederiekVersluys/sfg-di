package com.example.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("com")
public class ConstructorConfig {
    private final String userName;
    private final String password;
    private final String jdbcurl;

    public ConstructorConfig(String userName, String password, String jdbcurl) {
        this.userName = userName;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }
}
