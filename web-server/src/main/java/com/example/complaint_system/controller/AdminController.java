package com.example.complaint_system.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.complaint_system.domain.bo.AdminLoginBo;
import com.example.complaint_system.serivce.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(value = "管理员版块接口",tags = {"管理员版块接口"})
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    /**
     * @Auther Oh… Yeah!!! 2023-10-11
     * 管理员登录验证
     *      首先查看是否账号密码一致，如果一致则登入成功，返回给前端jwt。
     * @param
     * @return String.classs
     */
    @PostMapping("/login")
    @ApiOperation("管理员登入")
    public String adminLogin(@RequestBody AdminLoginBo adminLoginBo){
        return JSONArray.toJSONString(adminService.adminLogin(adminLoginBo));
    }

}
