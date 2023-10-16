package com.example.complaint_system.aop;

import org.aspectj.lang.JoinPoint;

public interface TaskControllerAop {
    /**
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String taskAdd(JoinPoint joinPoint);
}
