package com.todo.app.Utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public interface Logging {

    @Around(
            "execution(* com.todo.app.Controller..*(..)) || " +
                    "execution(* com.todo.app.Service..*(..)) || " +
                    "execution(* com.todo.app.Repository..*(..))"
    )
    Object aroundLoggingMethod(ProceedingJoinPoint joinPoint) throws Throwable;
}