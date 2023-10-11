package com.example.complaint_system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TaskImg implements Serializable {

    private Long id;
    private String imgUrl;
    private Long partId;
  //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;
    private Long createBy;
    private Long updateBy;
 //   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;
    private Integer status;
    private Integer delFlag;


    public TaskImg() {
    }

    public TaskImg(Long id, String imgUrl, Long partId, Date createTime, Long createBy, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.partId = partId;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
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
        return "TaskImg{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", partId=" + partId +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
