package com.example.complaint_system.domain.bo;

import java.io.Serializable;

public class TaskSelectByUserIdBo implements Serializable {
    private String token;

    public TaskSelectByUserIdBo(String token) {
        this.token = token;
    }

    public TaskSelectByUserIdBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TaskSelectByUserIdBo{" +
                "token='" + token + '\'' +
                '}';
    }
}
