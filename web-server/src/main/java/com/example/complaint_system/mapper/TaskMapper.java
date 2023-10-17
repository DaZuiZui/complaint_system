package com.example.complaint_system.mapper;

import com.example.complaint_system.domain.Task;
import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.TaskAndUserBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhuxinyu 2023-10-12
 *  投诉内容持久层
 */
@Mapper
public interface TaskMapper {


    /**
     * @auther zhuxinyu 2023-10-12
     *      根据context查询数据.
     * @param id
     * @return
     */
    public Task selectByIdTask(Long id);

    /**
     * @auther zhuxinyu 2023-10-12
     *     增加新数据
     * @param task
     * @return
     */
    public Long addTask(Task task);

    /**
     * @param id
     * @return
     * @auther zhuxinyu 2023-10-12
     * 通过id删除Task数据.
     */
    public Long deleteByIdTask(Long id);

    /**
     * @auther zhuxinyu 2023-10-12
     *      通过id更新Task数据.
     * @param task
     * @return
     */
    public Long updateByIdTask(Task task);

    /**
     * @return
     * @author hln 2023-10-13
     * 查询所有投诉信息
     */
    public List<TaskAndUserBo> taskSelectAll();

    public List<Task> getTaskByUserId(@Param("userId")Long userId);


    public Long taskSelectNow();

    /**
     * @author zhuxinyu 2023-10-12
     *      根据id查询user数据
     * @param id
     * @return
     */
    public List<User> selectByUserIdTask(Long id);
}
