package com.example.stub_from_kafka_to_postgres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgEntityRepository extends JpaRepository<Msg_Entity, Long> {
}
