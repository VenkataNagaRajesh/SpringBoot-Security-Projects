package com.example.kafkaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaspringboot.kafka.JsonKafkaProducer;
import com.example.kafkaspringboot.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user)
	{
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to kafka topic");
		
	}
}
