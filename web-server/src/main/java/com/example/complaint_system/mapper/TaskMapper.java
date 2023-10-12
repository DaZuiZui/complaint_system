package com.example.complaint_system.mapper;

import com.example.complaint_system.domain.Task;
import com.example.complaint_system.domain.bo.TaskAddByIdBo;
import org.apache.ibatis.annotations.Mapper;

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
}
