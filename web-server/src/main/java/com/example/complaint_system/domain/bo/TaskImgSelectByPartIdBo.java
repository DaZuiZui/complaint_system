package com.example.complaint_system.domain.bo;

import java.io.Serializable;

/**
 *  2023-10-12
 *  通过id查询task
 */
public class TaskImgSelectByPartIdBo implements Serializable {

    private String token;
    private Long partId;

    public TaskImgSelectByPartIdBo() {
    }

    public TaskImgSelectByPartIdBo(String token) {
        this.token = token;
    }

    public TaskImgSelectByPartIdBo(String token, Long partId) {
        this.token = token;
        this.partId = partId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    @Override
    public String toString() {
        return "TaskImgSelectByPartIdBo{" +
                "token='" + token + '\'' +
                ", partId=" + partId +
                '}';
    }
}
