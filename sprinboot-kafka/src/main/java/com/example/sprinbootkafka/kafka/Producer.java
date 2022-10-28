package com.example.sprinbootkafka.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public Producer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		System.out.println("Entered Producer class with Mssg::"+message);
		kafkaTemplate.send("Sujith","1", message);
		System.out.println("Sent Message to Topic ");
	}
}
