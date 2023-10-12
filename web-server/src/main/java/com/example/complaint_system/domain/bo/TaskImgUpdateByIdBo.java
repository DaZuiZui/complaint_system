package com.example.complaint_system.domain.bo;

import com.example.complaint_system.domain.TaskImg;

import java.io.Serializable;

public class TaskImgUpdateByIdBo implements Serializable {

    private String token;

    private TaskImg taskImg;

    public TaskImgUpdateByIdBo() {
    }

    public TaskImgUpdateByIdBo(String token, TaskImg taskImg) {
        this.token = token;
        this.taskImg = taskImg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TaskImg getTaskImg() {
        return taskImg;
    }

    public void setTaskImg(TaskImg taskImg) {
        this.taskImg = taskImg;
    }

    @Override
    public String toString() {
        return "TaskImgUpdateByIdBo{" +
                "token='" + token + '\'' +
                ", taskImg=" + taskImg +
                '}';
    }
}
