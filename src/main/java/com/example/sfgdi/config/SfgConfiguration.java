package com.example.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("com")
@Configuration
public class SfgConfiguration {
    private String userName;
    private String password;
    private String jdbcurl;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJbdcurl() {
        return jdbcurl;
    }

    public void setJbdcurl(String jbdcurl) {
        this.jdbcurl = jbdcurl;
    }
}
