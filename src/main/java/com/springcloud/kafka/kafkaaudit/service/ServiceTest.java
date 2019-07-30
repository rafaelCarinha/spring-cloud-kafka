package com.springcloud.kafka.kafkaaudit.service;

import com.springcloud.kafka.kafkaaudit.stream.Audits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceTest {

    @Audits(id = "1")
    public void log() {
        log.info("Log something");
    }
}
