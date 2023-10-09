package com.example.kafkaspringboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTempalte;
	
	public void sendMessage(String msg)
	{
		LOGGER.info(String.format("message sent %s", msg));
		kafkaTempalte.send("javaguides",msg);
	}
}
