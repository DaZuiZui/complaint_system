package com.example.complaint_system.domain;

import javax.naming.Context;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Task implements Serializable {
    private Long id;
    private Context context;
    private Date createTime;
    private Long createBy;
    private Long updateBy;
    private Date updateTime;
    private Integer status;
    private Integer delFlag;

    public Task(Long id, Context context, Date createTime, Long createBy, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.context = context;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", context=" + context +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
