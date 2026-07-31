package com.todo.app.Utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Aspect
@Component
public class LoggingImpl implements Logging {
    @Override
    public Object aroundLoggingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        Class declerationTypeDetails = joinPoint.getSignature().getDeclaringType();
        String type = "Unknown";

        if (declerationTypeDetails.isAnnotationPresent(RestController.class)) {
            type = "RestController";
        } else if (declerationTypeDetails.isAnnotationPresent(Controller.class)) {
            type = "Controller";
        } else if (declerationTypeDetails.isAnnotationPresent(Service.class)) {
            type = "Service";
        } else if (declerationTypeDetails.isAnnotationPresent(Repository.class)) {
            type = "Repository";
        }


        System.out.println("Start Logging for " + type + " : " + className + " : " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        System.out.println("End Logging for " + type + " : " + className + " : " + joinPoint.getSignature().getName());

        return result;
    }
}
