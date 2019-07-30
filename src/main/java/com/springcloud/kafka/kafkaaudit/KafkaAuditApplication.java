package com.springcloud.kafka.kafkaaudit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class KafkaAuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaAuditApplication.class, args);
    }

}
