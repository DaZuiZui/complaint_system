package com.example.complaint_system.domain.bo;

import com.example.complaint_system.domain.Task;

import java.io.Serializable;
import java.util.Date;

/**
 *    @author zhuxinyu 2023-10-12
 *      投诉内容添加实例
 */
public class TaskAddByIdBo implements Serializable {
    private String token;
    private Task task;    //内容实体类

    public TaskAddByIdBo(){

    }

    public TaskAddByIdBo(String token, Task task) {
        this.token = token;
        this.task = task;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskAddByIdBo{" +
                "token='" + token + '\'' +
                ", task=" + task +
                '}';
    }

    public TaskAddByIdBo setTask() {
        return null;
    }
}
