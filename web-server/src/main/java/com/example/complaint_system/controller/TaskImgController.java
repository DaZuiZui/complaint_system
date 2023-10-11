package com.example.complaint_system.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.complaint_system.domain.bo.TaskImgAddBo;
import com.example.complaint_system.domain.bo.TaskImgSelectByIdBo;
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
    public String articleSelect(@RequestBody TaskImgSelectByIdBo taskImgSelectByIdBo){
        return JSONArray.toJSONString(taskImgService.taskImgSelectById(taskImgSelectByIdBo));
    }


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      增加新数据.
     * @param taskImgAddBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加TaskImg数据")
    public String articleAdd(@RequestBody TaskImgAddBo taskImgAddBo){
        return JSONArray.toJSONString(taskImgService.taskImgAdd(taskImgAddBo));
    }


}
