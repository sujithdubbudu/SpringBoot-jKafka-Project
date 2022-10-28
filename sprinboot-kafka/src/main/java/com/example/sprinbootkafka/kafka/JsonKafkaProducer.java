package com.example.sprinbootkafka.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.sprinbootkafka.payload.User;

@Service
public class JsonKafkaProducer {

	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data)
	{
		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,"Sujith").build();
		kafkaTemplate.send(message);
	}
	
}
