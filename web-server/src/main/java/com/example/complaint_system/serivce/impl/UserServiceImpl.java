package com.example.complaint_system.serivce.impl;

import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.DeleteByIdBo;
import com.example.complaint_system.domain.bo.UserLoginBo;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.mapper.UserMapper;
import com.example.complaint_system.serivce.UserSerivce;
import com.example.complaint_system.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSerivce {
    @Autowired
    private UserMapper userMapper;

    /**
     * @author hanlaining 2023-10-11
     *      用户登录
     * @param userLoginBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userLogin(UserLoginBo userLoginBo) {
        //通过username 去获取用户
        User userInDB = userMapper.userLogin(userLoginBo);

        //比较用户密码和数据库中密码是否一致
        if (userInDB == null || !userInDB.getPassword().equals(userLoginBo.getPassword())){
            return new ResponseVo("账号或密码错误",null,"0x201");
        }

        String jwt = JwtUtil.createJWT(userInDB);

        return new ResponseVo("登入成功",jwt,"0x200");
    }

    /**
     * @param deleteByIdBo
     * @return
     * @author hln 2023-10-11
     * 通过id删除用户
     */
    @Override
    public ResponseVo deleteById(DeleteByIdBo deleteByIdBo) {
        Long numbersOfOpertion = userMapper.delelteById(deleteByIdBo.getId());
        if (numbersOfOpertion == null ||  numbersOfOpertion.longValue() == 0l) {
            return new ResponseVo("删除失败", null, "0x500");
        }

        return new ResponseVo("删除成功", numbersOfOpertion, "0x200");
    }

}
