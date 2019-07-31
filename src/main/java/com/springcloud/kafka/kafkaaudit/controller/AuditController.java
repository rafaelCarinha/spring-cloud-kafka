package com.springcloud.kafka.kafkaaudit.controller;


import com.springcloud.kafka.kafkaaudit.service.ServiceTest;
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

    ServiceTest serviceTest;

    @GetMapping("/audit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void audit(@RequestParam("message") String message) {

        serviceTest.log(message);
        log.info("testAroundAspect");

    }

}
