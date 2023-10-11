package com.example.complaint_system.domain.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu
 * 增加用户
 */

public class InsertByIdBo implements Serializable {
    private String username;
    private String password;
    private Integer college;
    private String org;
    private String grade;
    private String student_id;

    public InsertByIdBo(String username, String password, Integer college, String org, String grade, String student_id) {
        this.username = username;
        this.password = password;
        this.college = college;
        this.org = org;
        this.grade = grade;
        this.student_id = student_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "InsertByIdBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", college=" + college +
                ", org='" + org + '\'' +
                ", grade='" + grade + '\'' +
                ", student_id='" + student_id + '\'' +
                '}';
    }
}
