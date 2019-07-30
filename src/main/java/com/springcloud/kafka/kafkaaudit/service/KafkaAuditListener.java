package com.springcloud.kafka.kafkaaudit.service;

import com.springcloud.kafka.kafkaaudit.stream.Audit;
import com.springcloud.kafka.kafkaaudit.stream.AuditStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaAuditListener {

    @StreamListener(AuditStreams.INPUT)
    public void handleAudit(@Payload Audit audit) {
        log.info("Received audit: {}", audit);
    }
}
