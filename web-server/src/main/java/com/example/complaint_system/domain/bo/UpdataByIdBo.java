package com.example.complaint_system.domain.bo;

import com.example.complaint_system.domain.User;

import java.io.Serializable;

public class UpdataByIdBo implements Serializable {
    private String token;
    private User user;

    public UpdataByIdBo(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public UpdataByIdBo() {
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
        return "UpdataByIdBo{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
