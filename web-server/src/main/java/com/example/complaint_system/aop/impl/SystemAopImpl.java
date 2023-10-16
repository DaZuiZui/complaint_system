package com.example.complaint_system.aop.impl;


import com.example.complaint_system.aop.SystemAop;
import com.example.complaint_system.utils.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemAopImpl implements SystemAop {
    /**
     * @auhtor bryan yang
     * 清理ThreadLocal 防止内存泄漏
     * @param joinpoint
     * @throws Exception
     */
    @Override
    @After("execution(* com.example.complaint_system.controller.*.*(..))")
    public void removeAllThreadLocal(JoinPoint joinpoint) throws Exception {
        ThreadLocalUtil.mapThreadLocalOfJWT.remove();
        ThreadLocalUtil.mapThreadLocal.remove();
        ThreadLocalUtil.DataOfThreadLocal.remove();

    }
}
