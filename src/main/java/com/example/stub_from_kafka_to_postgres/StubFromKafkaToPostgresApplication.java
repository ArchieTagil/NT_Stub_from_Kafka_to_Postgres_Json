package com.example.stub_from_kafka_to_postgres;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class StubFromKafkaToPostgresApplication {

    @Autowired
    private MsgEntityRepository msgEntityRepository; //{ "msg_id": "1234567890", "timestamp": "1694171306000", "method": "POST", "uri": "/post-message" } 

    public static void main(String[] args) {
        SpringApplication.run(StubFromKafkaToPostgresApplication.class, args);
    }

    @KafkaListener(topics = "messages", groupId = "spring1")
    public void listen(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonData jsonData = objectMapper.readValue(message, JsonData.class);
        System.out.println("msg_id: " + jsonData.getMsg_id());
        System.out.println("timestamp: " + jsonData.getTimestamp());
        Msg_Entity msg_entity = new Msg_Entity(jsonData.getMsg_id(), jsonData.getTimestamp());
        msgEntityRepository.save(msg_entity);
    }

}