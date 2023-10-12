package com.example.complaint_system.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.*;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.serivce.UserSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 2023-10-11
 * 用户控制器
 */
@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    /**
     * @author hanlaining 2023-10-11
     * 登录验证
     *      首先查看是否账号密码一致，如果一致则登入成功，返回给前端jwt。
     * @param userLoginBo
     * @return String.classs
     */
    @PostMapping("/Login")
    @ApiOperation("用户登入")
    public String userLogin(@RequestBody UserLoginBo userLoginBo){
        if (userLoginBo == null){
            JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }

        return JSONArray.toJSONString(userSerivce.userLogin(userLoginBo));
    }

    /**
     * @author yuyu 2023-10-11
     *    删除用户通过id
     * @param deleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("删除用户通过id")
    public String deleteById(@RequestBody UserDeleteByIdBo deleteByIdBo){
        return JSONArray.toJSONString(userSerivce.deleteById(deleteByIdBo));
    }

    /**
     * @author yuyu 2023-9-16
     *    管理员查找用户通过id
     * @param selectByIdBo
     * @return String.class
     */
    @ApiOperation("管理员查找用户通过id")
    @PostMapping("/selectById")
    public String selectById(@RequestBody UserSelectByIdBo selectByIdBo){
        return JSONArray.toJSONString(userSerivce.selectById(selectByIdBo));
    }

    /**
     * @author hln 2023-10-11
     *    修改用户通过id
     * @param updataByIdBo
     * @return String.class
     */
    @ApiOperation("修改用户通过id")
    @PostMapping("/updata")
    public String updataById(@RequestBody UserUpdataByIdBo updataByIdBo){
        return JSONArray.toJSONString(userSerivce.updataById(updataByIdBo));
    }

    /**
     * @author zhuxinyu
     *用户注册
     *    用户注册，首先查看用户username是否存在如果存在则注册失败，如果当前username在数据库中不存在则注册成功。
     * @param user
     * @return String.class
     */
    @PostMapping("/userReg")
    @ApiOperation("用户注册")
    public String userReg(@RequestBody User user){
        if (user == null){
            JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }

        return JSONArray.toJSONString(userSerivce.userReg(user));
    }
}
