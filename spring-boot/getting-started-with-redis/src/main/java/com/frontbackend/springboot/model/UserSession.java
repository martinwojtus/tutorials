package com.frontbackend.springboot.model;

import java.util.Date;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Session")
public class UserSession {

    private String id;
    private String username;
    private Date loginTime;
    private String browser;

    public UserSession(String id, String username, Date loginTime, String browser) {
        this.id = id;
        this.username = username;
        this.loginTime = loginTime;
        this.browser = browser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", loginTime=" + loginTime +
                ", browser='" + browser + '\'' +
                '}';
    }
}
