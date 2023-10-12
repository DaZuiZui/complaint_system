package com.example.complaint_system.domain.bo;

import java.io.Serializable;

/**
 * 通过id删除task
 */
public class TaskImgDeleteByIdBo implements Serializable {

    private String token;
    private Long id;

    public TaskImgDeleteByIdBo() {
    }

    public TaskImgDeleteByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
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
        return "TaskImgDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
