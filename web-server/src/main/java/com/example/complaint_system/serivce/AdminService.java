package com.example.complaint_system.serivce;

import com.example.complaint_system.domain.bo.AdminLoginBo;
import com.example.complaint_system.domain.vo.ResponseVo;

/**
 * 管理员板块接口
 */
public interface AdminService {

    /**
     * @Auther Oh… Yeah!!! 2023-10-11
     * 管理员登录验证
     *      首先查看是否账号密码一致，如果一致则登入成功，返回给前端jwt。
     * @param adminLoginBo
     * @return ResponseVo.class
     */
    public ResponseVo adminLogin(AdminLoginBo adminLoginBo);

}
