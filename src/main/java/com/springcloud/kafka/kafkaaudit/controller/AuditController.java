package com.springcloud.kafka.kafkaaudit.controller;


import com.springcloud.kafka.kafkaaudit.service.KafkaAuditService;
import com.springcloud.kafka.kafkaaudit.service.ServiceTest;
import com.springcloud.kafka.kafkaaudit.stream.Audit;
import com.springcloud.kafka.kafkaaudit.stream.Audits;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AuditController {

    private final KafkaAuditService kafkaAuditService;

    ServiceTest serviceTest;

    @GetMapping("/audit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void audit(@RequestParam("message") String message) {
        Audit audit = Audit.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();

        testAroundAspect();

        //kafkaAuditService.sendAudit(audit);
    }


    public void testAroundAspect() {

        serviceTest.log();
        log.info("testAroundAspect");

    }

}
