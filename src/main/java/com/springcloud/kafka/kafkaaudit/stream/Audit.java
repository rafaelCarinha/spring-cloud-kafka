package com.springcloud.kafka.kafkaaudit.stream;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

    private String id;
    private long timestamp;
    private String message;

}
