package com.example.complaint_system.domain.bo;

import java.io.Serializable;

public class TaskSelectByUserIdBo implements Serializable {
    private String token;
    private Long id;

    public TaskSelectByUserIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public TaskSelectByUserIdBo() {
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

    @Override
    public String toString() {
        return "TaskSelectByUserIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
