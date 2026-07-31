package com.todo.app.Utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public interface Logging {
    @Around("execution(* com.todo.app..*(..))")
    public Object aroundLoggingMethod(ProceedingJoinPoint joinPoint) throws Throwable;
}
