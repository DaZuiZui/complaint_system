package com.example.complaint_system.serivce;

import com.example.complaint_system.domain.bo.*;
import com.example.complaint_system.domain.vo.ResponseVo;

/**
 * 用户业务接口
 */
public interface UserSerivce {
    /**
     * @author hln 2023-10-11
     * 登录验证
     *      首先查看是否账号密码一致，如果一致则登入成功，返回给前端jwt。
     * @param userLoginBo
     * @return ResponseVo.class
     */
    public ResponseVo userLogin(UserLoginBo userLoginBo);

    /**
     * @author hln 2023-10-11
     *    通过id删除用户
     * @param deleteByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo deleteById(UserDeleteByIdBo deleteByIdBo);

    /**
     * @author hln 2023-10-11
     *    通过id查找用户
     * @param selectByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo selectById(UserSelectByIdBo selectByIdBo);

    /**
     * @author hln 2023-10-11
     *    通过id修改用户
     * @param updataByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo updataById(UpdataByIdBo updataByIdBo);

    /**
     * @author zhuxinyu 2023-10-11
     *用户注册
     *      用户注册，首先查看用户username是否存在如果存在则注册失败，如果当前username在数据库中不存在则注册成功。
     * @param userRegBo
     * @return ResponseVo.class
     */

    public ResponseVo userReg(UserRegBo userRegBo);
}
