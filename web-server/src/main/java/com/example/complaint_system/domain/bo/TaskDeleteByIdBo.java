package com.example.complaint_system.domain.bo;

import java.io.Serializable;

/**
 *    @author zhuxinyu 2023-10-12
 *      投诉内容删除实例
 */
public class TaskDeleteByIdBo implements Serializable {
    private String token;
    private Long id;

    @Override
    public String toString() {
        return "TaskDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskDeleteByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }
}
