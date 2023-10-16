package com.example.complaint_system.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.complaint_system.domain.bo.TaskAddBo;
import com.example.complaint_system.domain.bo.TaskDeleteByIdBo;
import com.example.complaint_system.domain.bo.TaskSelectByIdBo;
import com.example.complaint_system.domain.bo.TaskUpdateByIdBo;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.serivce.TaskService;
import com.example.complaint_system.utils.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

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
    public String taskAdd(@RequestBody TaskAddBo taskAddByIdBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

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


    /**
     * @author zhuxinyu 2023-10-13
     *      查询所有数据
     * @param
     * @return
     */
    @PostMapping("/selectAll")
    @ApiOperation("查询所有数据")
    public String taskSelectAll(){
        return JSONArray.toJSONString(taskService.taskSelectAll());
    }

}
