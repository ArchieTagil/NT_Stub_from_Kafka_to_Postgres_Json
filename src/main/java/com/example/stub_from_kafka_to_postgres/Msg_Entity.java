package com.example.stub_from_kafka_to_postgres;

import jakarta.persistence.*;

@Entity
@Table(name  = "msg_info", schema = "public")
public class Msg_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "msgId") //msg_id
    private Long msgId;
    @Column(name = "timeRq")
    private Long timeRq;

    public Msg_Entity() {
    }

    public Msg_Entity(Long msgId, Long timeRq) {
        this.msgId = msgId;
        this.timeRq = timeRq;
    }
}
