package com.springcloud.kafka.kafkaaudit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.springcloud.kafka.kafkaaudit.aop", "com.springcloud.kafka.kafkaaudit.stream"})
@EnableAspectJAutoProxy
public class ApplicationConfig {
}
