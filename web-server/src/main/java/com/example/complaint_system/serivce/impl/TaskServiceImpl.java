package com.example.complaint_system.serivce.impl;

import com.example.complaint_system.domain.Task;
import com.example.complaint_system.domain.User;
import com.example.complaint_system.domain.bo.*;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.mapper.TaskMapper;
import com.example.complaint_system.serivce.TaskService;
import com.example.complaint_system.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *  2023-10-12
 *  投诉内容业务接口实现类
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    /**
     * @author zhuxinyu 2023-10-12
     *      根据id查询数据
     * @param taskSelectByIdBo
     * @return
     */
    @Override
    public ResponseVo taskSelectById(TaskSelectByIdBo taskSelectByIdBo){

        Task task = taskMapper.selectByIdTask(taskSelectByIdBo.getId());

        if (task == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功",task,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-12
     *      根据id查询user数据
     * @param taskSelectByUserIdBo
     * @return
     */
    @Override
    public ResponseVo taskSelectByUserId(TaskSelectByUserIdBo taskSelectByUserIdBo) {
        String taskIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long taskId = Long.valueOf(taskIdOfStr);
        List<Task> list = taskMapper.selectByUserIdTask(taskId);

        if (list == null || taskId == 0L) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-12
     *      添加数据
     * @param taskAddByIdBo
     * @return
     */
    @Override
    public ResponseVo taskAdd(TaskAddBo taskAddByIdBo){
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        taskAddByIdBo.getTask().setCreateBy(userId);
        taskAddByIdBo.getTask().setCreateTime(new Date());
        Long  aLong = taskMapper.addTask(taskAddByIdBo.getTask());
        if (aLong.longValue() == 0) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        Long id = taskMapper.taskSelectNow();

        return new ResponseVo("增加成功", id, "0x200");
    }

    /**
     * @author  zhuxinyu 2023-10-12
     *      通过id删除task数据
     * @param taskDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo taskDeleteById(TaskDeleteByIdBo taskDeleteByIdBo){

        Long id = taskDeleteByIdBo.getId();

        Long  numbersOfOpetion= taskMapper.deleteByIdTask(id);
        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",id, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-12
     *      通过id更新Task数据
     * @param taskUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo taskUpdateById(TaskUpdateByIdBo taskUpdateByIdBo){
        String taskIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long taskId = Long.valueOf(taskIdOfStr);
        taskUpdateByIdBo.getTask().setUpdateBy(taskId);
        taskUpdateByIdBo.getTask().setUpdateTime(new Date());
        Task task = taskUpdateByIdBo.getTask();
        Long numberOfOpertion = taskMapper.updateByIdTask(task);

        if (numberOfOpertion.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", task.getId(), "0x200");
    }


    /**
     * @author hln 2023-10-13
     *      通过id更新Task数据
     * @return
     */
    @Override
    public ResponseVo taskSelectAll() {
        List<TaskAndUserBo> list = taskMapper.taskSelectAll();

        return new ResponseVo("查询成功",list,"0x200");
    }
}
