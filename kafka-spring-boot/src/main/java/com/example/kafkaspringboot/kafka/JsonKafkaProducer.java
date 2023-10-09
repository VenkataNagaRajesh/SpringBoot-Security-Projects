package com.example.kafkaspringboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafkaspringboot.payload.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
			
		@Autowired
		private KafkaTemplate<String,User> kafkaTemplate;
	
	
	public void sendMessage(User data)
	{
		
		LOGGER.info("message sent -> %s",data.toString());
		
		Message<User> message = MessageBuilder
				.withPayload(data).
				setHeader(KafkaHeaders.TOPIC, "javaguidesJson")
				.build();
		kafkaTemplate.send(message);
	}
}
