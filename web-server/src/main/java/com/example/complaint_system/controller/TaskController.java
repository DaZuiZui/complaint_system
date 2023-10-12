package com.example.complaint_system.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.complaint_system.domain.bo.TaskAddByIdBo;
import com.example.complaint_system.domain.bo.TaskDeleteByIdBo;
import com.example.complaint_system.domain.bo.TaskSelectByIdBo;
import com.example.complaint_system.domain.bo.TaskUpdateByIdBo;
import com.example.complaint_system.serivce.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author zhuxinyu 2023-10-12
 *  投诉内容板块接口
 */
@CrossOrigin
@Api(value = "投诉内容板块接口",tags = {"投诉内容板块接口"})
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * @author zhuxinyu 2023-10-12
     *      数据查询
     * @param taskSelectByIdBo
     * @return
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询Task数据")
    public String taskSelectById(@RequestBody TaskSelectByIdBo taskSelectByIdBo){
        return JSONArray.toJSONString(taskService.taskSelectById(taskSelectByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-12
     *        添加数据
     * @param taskAddByIdBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("通过id添加task数据")
    public String taskAdd(@RequestBody TaskAddByIdBo taskAddByIdBo){
        return JSONArray.toJSONString(taskService.taskAdd(taskAddByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-12
     *          删除数据
     * @param taskDeleteByIdBo
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除task数据")
    public String taskDeleteById(@RequestBody TaskDeleteByIdBo taskDeleteByIdBo){
        return JSONArray.toJSONString(taskService.taskDeleteById(taskDeleteByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-12
     *          更新数据
     * @param taskUpdateByIdBo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("通过id更新task数据")
    public String taskUpdateById(@RequestBody TaskUpdateByIdBo taskUpdateByIdBo){
        return JSONArray.toJSONString(taskService.taskUpdateById(taskUpdateByIdBo));
    }
}
