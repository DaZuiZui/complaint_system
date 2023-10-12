package com.example.complaint_system.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api(value = "投诉内容板块接口",tags = {"投诉内容板块接口"})
@RestController
@RequestMapping("/task")
public class TaskController {

}
