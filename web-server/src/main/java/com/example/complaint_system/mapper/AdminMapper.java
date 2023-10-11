package com.example.complaint_system.mapper;

import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.AdminLoginBo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {


    /**
     * @Auther Oh… Yeah!!! 2023-10-11
     *      管理员登录验证
     * @param   adminLoginBo
     * @return User.class
     */
    public User adminLogin(AdminLoginBo adminLoginBo);



}
