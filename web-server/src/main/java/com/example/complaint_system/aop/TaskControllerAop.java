package com.example.complaint_system.aop;

import org.aspectj.lang.JoinPoint;

public interface TaskControllerAop {
    public String taskAdd(JoinPoint joinPoint);
}
