package com.example.complaint_system.domain.bo;

import com.example.complaint_system.domain.Task;

import java.io.Serializable;

/**
 *    @author zhuxinyu 2023-10-12
 *      投诉内容更新实例
 */
public class TaskUpdateByIdBo implements Serializable {
    private String token;
    private Task Task; //投诉内容

    @Override
    public String toString() {
        return "TaskUpdateByIdBo{" +
                "token='" + token + '\'' +
                ", Task=" + Task +
                '}';
    }

    public TaskUpdateByIdBo(String token, com.example.complaint_system.domain.Task task) {
        this.token = token;
        Task = task;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public com.example.complaint_system.domain.Task getTask() {
        return Task;
    }

    public void setTask(com.example.complaint_system.domain.Task task) {
        Task = task;
    }
}
