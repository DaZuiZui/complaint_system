package com.example.complaint_system.domain.bo;

import java.io.Serializable;

/**
 *    @author zhuxinyu 2023-10-12
 *      投诉内容更新实例
 */
public class TaskUpdataByIdBo implements Serializable {
    private String token;
    private String context; //投诉内容

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
