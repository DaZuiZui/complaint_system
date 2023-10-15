package com.example.complaint_system.domain.bo;

import java.io.Serializable;
import java.util.Date;

public class TaskAndUserBo implements Serializable {
    private String token;
    private String username;    //用户名
    private String context;    //投诉内容
    private Long id;
    private Date createTime;    //创建时间
    private Date updateTime;    //修改时间

    public TaskAndUserBo(String token, String username, String context, Long id, Date createTime, Date updateTime) {
        this.token = token;
        this.username = username;
        this.context = context;
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TaskAndUserBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TaskAndUserBo{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", context='" + context + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
