package com.example.complaint_system.serivce.impl;

import com.example.complaint_system.domain.Task;
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
     *      添加数据
     * @param taskAddByIdBo
     * @return
     */
    @Override
    public ResponseVo taskAdd(TaskAddBo taskAddByIdBo){
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        Long  aLong = taskMapper.addTask(taskAddByIdBo.getTask());
        List<Task> taskByUserId = taskMapper.getTaskByUserId(userId);
        if (aLong.longValue() == 0) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        return new ResponseVo("增加成功", taskByUserId, "0x200");
    }

    /**
     * @author  zhuxinyu 2023-10-12
     *      通过id删除task数据
     * @param taskDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo taskDeleteById(TaskDeleteByIdBo taskDeleteByIdBo){

        Long  numbersOfOpetion= taskMapper.deleteByIdTask(taskDeleteByIdBo.getId());
        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-12
     *      通过id更新Task数据
     * @param taskUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo taskUpdateById(TaskUpdateByIdBo taskUpdateByIdBo){
        Task task = taskUpdateByIdBo.getTask();
        Long numberOfOpertion = taskMapper.updateByIdTask(task);

        if (numberOfOpertion.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", null, "0x200");
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
