package com.springcloud.kafka.kafkaaudit.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface AuditStreams {

    String INPUT = "audit-in";
    String OUTPUT = "audit-out";

    @Input(INPUT)
    SubscribableChannel inboundAudit();

    @Output(OUTPUT)
    MessageChannel outboundAudit();
}
