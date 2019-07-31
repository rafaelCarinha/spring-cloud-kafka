package com.springcloud.kafka.kafkaaudit.service;

import com.springcloud.kafka.kafkaaudit.stream.Audits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceTest {

    @Audits(id = "1", message = "Log Something")
    public void log(String message) {
        log.info("Message from Controller: {}", message);
    }
}
