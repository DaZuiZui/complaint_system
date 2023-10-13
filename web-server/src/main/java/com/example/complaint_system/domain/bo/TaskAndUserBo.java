package com.example.complaint_system.domain.bo;

import java.io.Serializable;

public class TaskAndUserBo implements Serializable {
    private String token;
    private String username;    //用户名
    private String context;    //投诉内容

    public TaskAndUserBo(String token, String username, String context) {
        this.token = token;
        this.username = username;
        this.context = context;
    }

    public TaskAndUserBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "TaskAndUserBo{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
