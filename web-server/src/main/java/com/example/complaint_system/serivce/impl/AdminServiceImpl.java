package com.example.complaint_system.serivce.impl;

import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.AdminLoginBo;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.mapper.AdminMapper;
import com.example.complaint_system.serivce.AdminService;
import com.example.complaint_system.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 2023-10-11
 * 管理员版块接口实现类
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * @Auther Oh… Yeah!!! 2023-10-11
     * 管理员登录验证
     *      首先查看是否账号密码一致，如果一致则登入成功，返回给前端jwt。
     * @param
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo adminLogin(AdminLoginBo adminLoginBo) {
        //通过username 去获取用户
        User user = adminMapper.adminLogin(adminLoginBo);

        //比较是否为admin
        if (user.getRole() == null || user.getRole() == 0) {
            //to do is not admin
            return new ResponseVo("此用户不是管理员,请重新登录", null, "0x201");
        }

        //比较用户密码和数据库中密码是否一致
        if (user == null || !user.getPassword().equals(adminLoginBo.getPassword())) {
            return new ResponseVo("账号或者密码错误", null, "0x201");
        }

        String jwt = JwtUtil.createJWT(user);

        return new ResponseVo("登入成功", jwt, "0x200");
    }
}
