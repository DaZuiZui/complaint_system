package com.example.complaint_system.domain.bo;

import java.io.Serializable;

/**
 * 通过id删除
 */
public class UserDeleteByIdBo implements Serializable {
    private String token;
    private Long id;

    public UserDeleteByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public UserDeleteByIdBo() {
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
        return "UserDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
