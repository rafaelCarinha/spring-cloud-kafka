package com.springcloud.kafka.kafkaaudit.aop;

import com.springcloud.kafka.kafkaaudit.stream.Audit;
import com.springcloud.kafka.kafkaaudit.stream.AuditStreams;
import com.springcloud.kafka.kafkaaudit.stream.Audits;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class AuditAspect {

    private final AuditStreams auditStreams;

    @Pointcut(" (@annotation(com.springcloud.kafka.kafkaaudit.stream.Audits))")
    private void anyMethodAnnotatedWithAudits() { }

    @Around(value = "anyMethodAnnotatedWithAudits()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {

        Audits audit = getAudit(pjp);

        Object result = pjp.proceed();

        log.info("Sending audit {}", audit);

        MessageChannel messageChannel = auditStreams.outboundAudit();
        messageChannel.send(MessageBuilder
                .withPayload(audit)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

        log.info("Success Sending audit {}", audit);

        return result;
    }

    protected Audits getAudit(JoinPoint jp) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotation(Audits.class);
    }
}
