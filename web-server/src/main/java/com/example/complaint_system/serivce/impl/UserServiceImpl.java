package com.example.complaint_system.serivce.impl;

import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.*;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.mapper.UserMapper;
import com.example.complaint_system.serivce.UserSerivce;
import com.example.complaint_system.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 用户业务接口实现
 */
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
        Integer role = userInDB.getRole();

        //登录时权限变为用户角色
        userInDB.setRole(0);

        HashMap<String,Object> map = new HashMap<>();
        map.put("jwt",jwt);
        map.put("role",role);

        return new ResponseVo("登入成功",map,"0x200");
    }

    /**
     * @param deleteByIdBo
     * @return
     * @author hln 2023-10-11
     * 通过id删除用户
     */
    @Override
    public ResponseVo deleteById(UserDeleteByIdBo deleteByIdBo) {
        Long numbersOfOpertion = userMapper.delelteById(deleteByIdBo.getId());
        if (numbersOfOpertion == null ||  numbersOfOpertion.longValue() == 0l) {
            return new ResponseVo("删除失败", null, "0x500");
        }

        return new ResponseVo("删除成功", numbersOfOpertion, "0x200");
    }

    /**
     * @author hln 2023-10-11
     *    管理员查找用户通过id
     * @param selectByIdBo
     * @return String.class
     */
    @Override
    public ResponseVo selectById(UserSelectByIdBo selectByIdBo) {
        User user = userMapper.selectById(selectByIdBo.getId());

        return new ResponseVo(null, user, "0x200");
    }

    /**
     * @author hln 2023-10-11
     *    管理员修改用户通过id
     * @param updataByIdBo
     * @return String.class
     */
    @Override
    public ResponseVo updataById(UserUpdataByIdBo updataByIdBo) {
        updataByIdBo.getUser().setUpdateBy(1l);
        updataByIdBo.getUser().setUpdateTime(new Date());
        Long numbersOfOpertion = userMapper.updataById(updataByIdBo.getUser());

        if (numbersOfOpertion == null|| numbersOfOpertion.longValue() == 0 ){
            return new ResponseVo("修改失败", null, "0x500");
        }

        return new ResponseVo("修改成功", null, "0x200");
    }


    /**
     * @author zhuxinyu 2023-10-11
     * 用户注册
     *      用户注册，首先查看用户username是否存在如果存在则注册失败，如果当前username在数据库中不存在则注册成功。
     * @param user
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userReg(User user) {
        User byUsername = userMapper.findByUsername(user.getUsername());

        if (byUsername != null){
            return new ResponseVo("该username已经存在",null,"0x202");
        }

        user.setCreateTime(new Date());

        Long aLong = userMapper.userReg(user);
        if (aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x500");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    /**
     * @author hln 2023-10-12
     *      查询所有用户功能
     * @param
     * @return
     */
    @Override
    public ResponseVo userFindAll() {
        List<User> list = userMapper.userFindAll();
        return new ResponseVo("查询成功",list,"0x200");
    }

}
