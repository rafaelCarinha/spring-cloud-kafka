package com.springcloud.kafka.kafkaaudit.aop;

import com.springcloud.kafka.kafkaaudit.stream.Audit;
import com.springcloud.kafka.kafkaaudit.stream.Audits;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Configuration
@ComponentScan(basePackages = {"com.springcloud.kafka.kafkaaudit.aop", "com.springcloud.kafka.kafkaaudit.stream"})
@Slf4j
public class AuditAspect {

    @Around(value = "com.springcloud.kafka.kafkaaudit.aop.SystemArchitecture.anyMethodAnnotatedWithAudits()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {

        Object result = pjp.proceed();

        Audits audit = getAudit(pjp);

        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        log.info("Audited with Around");
        return retval;
    }

    protected Audits getAudit(JoinPoint jp) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotation(Audits.class);
    }
}
