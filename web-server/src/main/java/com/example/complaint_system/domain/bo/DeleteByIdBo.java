package com.example.complaint_system.domain.bo;

import java.io.Serializable;

public class DeleteByIdBo implements Serializable {
    private String token;
    private Long id;

    public DeleteByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public DeleteByIdBo() {
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
        return "DeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
