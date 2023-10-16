package com.example.complaint_system.domain;

import com.baomidou.mybatisplus.annotation.Version;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuxinyu 2023-10-12
 *投诉内容实体类
 */
public class Task implements Serializable {
    private Long id;
    private String context;    //投诉内容
    private Date createTime;    //创建时间
    private Long createBy;      //创建人
    private Long updateBy;      //修改人
    private Date updateTime;    //修改时间
    private Integer status;     //0 正常投诉 2 匿名投诉
    private Integer delFlag;    //0未删除 1正常

    public Task() {
    }

    public Task(Long id, String context, Date createTime, Long createBy, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
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
                ", context='" + context + '\'' +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
