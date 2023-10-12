package com.example.complaint_system.domain.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu
 * 用户注册
 */
public class UserRegBo implements Serializable {
    private String token;
    private String username;
    private String password;
    private String name;
    private Integer college;
    private String org;
    private String grade;
    private String student_id;
    private Integer status;

    @Override
    public String toString() {
        return "UserRegBo{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", org='" + org + '\'' +
                ", grade='" + grade + '\'' +
                ", student_id='" + student_id + '\'' +
                ", status=" + status +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserRegBo(String token, String username, String password, String name, Integer college, String org, String grade, String student_id, Integer status) {
        this.token = token;
        this.username = username;
        this.password = password;
        this.name = name;
        this.college = college;
        this.org = org;
        this.grade = grade;
        this.student_id = student_id;
        this.status = status;
    }
}
