package com.example.sfgdi.datasource;

public class FakeDataSource {

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
