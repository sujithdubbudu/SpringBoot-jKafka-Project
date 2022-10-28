package com.example.sprinbootkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprinbootkafka.kafka.JsonKafkaProducer;
import com.example.sprinbootkafka.kafka.Producer;
import com.example.sprinbootkafka.payload.User;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

	private Producer kafkaProducer;

	private JsonKafkaProducer JsonkafkaProducer;
	public MessageController(Producer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;

	}

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		System.out.println("Entered with msg ::"+message);
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message Sent");
	}

	@PostMapping("/sendJson")
	public ResponseEntity<String> publish(@RequestBody User user){
		JsonkafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Message Sent");
	}
}
