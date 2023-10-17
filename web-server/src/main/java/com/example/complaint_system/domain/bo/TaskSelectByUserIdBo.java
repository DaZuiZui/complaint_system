package com.example.complaint_system.domain.bo;

import java.io.Serializable;

public class TaskSelectByUserIdBo implements Serializable {
    private String token;
    private String username;

    public TaskSelectByUserIdBo(String token, String username) {
        this.token = token;
        this.username = username;
    }

    public TaskSelectByUserIdBo() {
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

    @Override
    public String toString() {
        return "TaskSelectByUserIdBo{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
