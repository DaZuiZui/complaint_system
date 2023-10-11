package com.example.complaint_system.mapper;

import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.UserLoginBo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户持久层
 */
@Mapper
public interface UserMapper {
    /**
     * @author hln 2023-10-11
     * 通过username获得用户实体
     * @param userLoginBo
     * @return
     */
    public User userLogin(UserLoginBo userLoginBo);

    /**
     * @author hln 2023-10-11
     * 删除用户
     * @param id
     * @return
     */
    public Long delelteById(Long id);

    /**
     * @author hln 2023-10-11
     *     通过id查询数据
     * @param id
     * @return
     */
    public User selectById(Long id);

    /**
     * @author hln 2023-10-11
     *      通过id修改数据
     * @param user
     * @return
     */
    public Long updataById(User user);
}
