package com.example.sprinbootkafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	@KafkaListener(topics = "Sujith", groupId = "myGroup")
	public void consume(String message) {

		System.out.println("Message Coming as ::" + message);
	}

}
