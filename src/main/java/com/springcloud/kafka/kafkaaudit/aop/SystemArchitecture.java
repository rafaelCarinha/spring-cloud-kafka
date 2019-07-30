package com.springcloud.kafka.kafkaaudit.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemArchitecture {

    @Pointcut(" (@annotation(com.springcloud.kafka.kafkaaudit.stream.Audits))")
    public void anyMethodAnnotatedWithAudits() {
    }
}
