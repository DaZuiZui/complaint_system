package com.example.complaint_system.aop.impl;

import com.example.complaint_system.aop.TaskControllerAop;
import com.example.complaint_system.domain.bo.TaskAddBo;
import com.example.complaint_system.domain.bo.TaskSelectByIdBo;
import com.example.complaint_system.serivce.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TaskControllerAopImpl implements TaskControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.example.complaint_system.controller.TaskController.taskAdd(..))")
    public String taskAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        TaskAddBo arg = (TaskAddBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
        return null;
    }

    /**
     * 做了权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.example.complaint_system.controller.TaskController.taskSelectById(..))")
    public String taskSelectById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        TaskSelectByIdBo taskSelectByIdBos = (TaskSelectByIdBo) args[0];
        String token = taskSelectByIdBos.getToken();
        systemService.auth(token);
        return null;
    }
}
