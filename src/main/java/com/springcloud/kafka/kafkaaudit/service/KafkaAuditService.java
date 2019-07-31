package com.springcloud.kafka.kafkaaudit.service;

import com.springcloud.kafka.kafkaaudit.stream.Audit;
import com.springcloud.kafka.kafkaaudit.stream.AuditStreams;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaAuditService {

    private final AuditStreams auditStreams;

    public void sendAudit(final Audit audit) {
        log.info("Sending audit: {}", audit);

        MessageChannel messageChannel = auditStreams.outboundAudit();
        messageChannel.send(MessageBuilder
                .withPayload(audit)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
