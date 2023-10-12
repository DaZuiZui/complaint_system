package com.example.complaint_system.domain.bo;

import com.example.complaint_system.domain.User;

import java.io.Serializable;

/**
 * 通过id修改用户
 */
public class UserUpdataByIdBo implements Serializable {
    private String token;
    private User user;

    public UserUpdataByIdBo(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public UserUpdataByIdBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserUpdataByIdBo{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
