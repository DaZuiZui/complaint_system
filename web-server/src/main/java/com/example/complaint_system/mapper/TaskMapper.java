package com.example.complaint_system.mapper;

import com.example.complaint_system.domain.Task;
import com.example.complaint_system.domain.bo.TaskAddByIdBo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
    /**
     * @auther zhuxinyu 2023-10-12
     *      根据id查询数据.
     * @param id
     * @return
     */
    public Task selectById(Long id);

    /**
     * @auther zhuxinyu 2023-10-12
     *      根据context查询数据.
     * @param context
     * @return
     */
    public Task selectByContext(String context);

    /**
     * @auther zhuxinyu 2023-10-12
     *      增加新数据.
     * @param taskAddByIdBo
     * @return
     */
    public Task addTask(TaskAddByIdBo taskAddByIdBo);

    /**
     * @auther zhuxinyu 2023-10-12
     *      通过id删除Task数据.
     * @param id
     * @return
     */
    public Task deleteByIdTask(Long id);

    /**
     * @auther zhuxinyu 2023-10-12
     *      通过id更新Task数据.
     * @param task
     * @return
     */
    public Long updateByIdTask(Task task);
}
