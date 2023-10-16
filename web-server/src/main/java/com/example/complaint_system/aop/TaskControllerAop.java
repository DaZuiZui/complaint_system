package com.example.complaint_system.aop;

import com.example.complaint_system.domain.bo.TaskSelectByIdBo;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.bind.annotation.RequestBody;

public interface TaskControllerAop {
    /**
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String taskAdd(JoinPoint joinPoint);

    public String taskSelectById(JoinPoint joinPoint);
}
