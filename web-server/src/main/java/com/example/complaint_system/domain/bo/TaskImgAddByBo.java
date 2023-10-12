package com.example.complaint_system.domain.bo;

import com.example.complaint_system.domain.TaskImg;

import java.io.Serializable;
import java.util.Date;

/**
 * 投诉图片添加bo
 */
public class TaskImgAddByBo implements Serializable {

    private String token;
    private TaskImg taskImg;

    public TaskImgAddByBo() {
    }

    public TaskImgAddByBo(String token, TaskImg taskImg) {
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
        return "TaskImgAddByBo{" +
                "token='" + token + '\'' +
                ", taskImg=" + taskImg +
                '}';
    }
}
