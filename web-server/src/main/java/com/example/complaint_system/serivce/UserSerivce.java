package com.example.complaint_system.serivce;

import com.example.complaint_system.domain.bo.DeleteByIdBo;
import com.example.complaint_system.domain.bo.SelectByIdBo;
import com.example.complaint_system.domain.bo.UpdataByIdBo;
import com.example.complaint_system.domain.bo.UserLoginBo;
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
    public ResponseVo deleteById(DeleteByIdBo deleteByIdBo);

    /**
     * @author hln 2023-10-11
     *    通过id查找用户
     * @param selectByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo selectById(SelectByIdBo selectByIdBo);

    /**
     * @author hln 2023-10-11
     *    通过id修改用户
     * @param updataByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo updataById(UpdataByIdBo updataByIdBo);
}
