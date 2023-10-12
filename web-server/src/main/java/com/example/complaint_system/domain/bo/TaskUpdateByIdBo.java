package com.example.complaint_system.domain.bo;

import com.example.complaint_system.domain.Task;

import java.io.Serializable;

/**
 *    @author zhuxinyu 2023-10-12
 *      投诉内容更新实例
 */
public class TaskUpdateByIdBo implements Serializable {
    private String token;
    private Task context; //投诉内容

    @Override
    public String toString() {
        return "TaskUpdateByIdBo{" +
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

    public Task getContext() {
        return context;
    }

    public void setContext(Task context) {
        this.context = context;
    }

    public TaskUpdateByIdBo(String token, Task context) {
        this.token = token;
        this.context = context;
    }
}
