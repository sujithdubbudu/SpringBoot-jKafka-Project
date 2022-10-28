package com.example.sprinbootkafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import com.example.sprinbootkafka.payload.User;

public class JsonKafkaConsumer {

	@KafkaListener(topics = "Sujith", groupId = "myGroup")
	public void consume(User user) {

	}
}
