package com.example.complaint_system.domain.bo;

import java.io.Serializable;


/**
 * 通过id查询用户
 */
public class UserSelectByIdBo implements Serializable {
    private String token;
    private Long id;

    public UserSelectByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public UserSelectByIdBo() {
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
        return "UserSelectByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
