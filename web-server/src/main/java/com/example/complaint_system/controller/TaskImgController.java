package com.example.complaint_system.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.complaint_system.domain.bo.TaskImgAddByBo;
import com.example.complaint_system.domain.bo.TaskImgDeleteByIdBo;
import com.example.complaint_system.domain.bo.TaskImgSelectByIdBo;
import com.example.complaint_system.domain.bo.TaskImgUpdateByIdBo;
import com.example.complaint_system.serivce.TaskImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(value = "投诉照片板块接口",tags = {"投诉照片板块接口"})
@RestController
@RequestMapping("/task_img")
public class TaskImgController {

    @Autowired
    private TaskImgService taskImgService;


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      根据id查询数据.
     * @param taskImgSelectByIdBo
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询TaskImg数据")
    public String taskImgSelect(@RequestBody TaskImgSelectByIdBo taskImgSelectByIdBo){
        return JSONArray.toJSONString(taskImgService.taskImgSelectById(taskImgSelectByIdBo));
    }


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      增加新数据.
     * @param taskImgAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加TaskImg数据")
    public String taskImgAdd(@RequestBody TaskImgAddByBo taskImgAddByBo){
        return JSONArray.toJSONString(taskImgService.taskImgAdd(taskImgAddByBo));
    }

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      通过id删除TaskImg数据.
     * @param taskImgDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除TaskImg数据")
    public String taskImgDeleteById(@RequestBody TaskImgDeleteByIdBo taskImgDeleteByIdBo){
        return JSONArray.toJSONString(taskImgService.taskImgDeleteById(taskImgDeleteByIdBo));
    }


    /**
     * @author Oh… Yeah, 2023-9-12
     *      通过id更新TaskImg数据.
     * @param taskImgUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("管理员通过id修改TaskImg数据")
    @PostMapping("/update")
    public String taskImgUpdateById(@RequestBody TaskImgUpdateByIdBo taskImgUpdateByIdBo){
        return JSONArray.toJSONString(taskImgService.taskImgUpdateById(taskImgUpdateByIdBo));
    }





}


