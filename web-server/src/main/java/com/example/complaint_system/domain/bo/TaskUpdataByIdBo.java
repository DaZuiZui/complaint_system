package com.example.complaint_system.domain.bo;

import java.io.Serializable;

public class TaskUpdataByIdBo implements Serializable {
    private String token;
    private String context;

    @Override
    public String toString() {
        return "TaskUpdataByIdBo{" +
                "token='" + token + '\'' +
                ", context='" + context + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public TaskUpdataByIdBo(String token, String context) {
        this.token = token;
        this.context = context;
    }
}
