package com.example.SpringWithKafkaProducer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class KafkaProducerController {
	
	private List<String> messages = new ArrayList<>();
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/{name}")
	public void sendToKafka(@PathVariable("name") String name) {
		kafkaTemplate.send("myfirsttopic", "Hello " + name);
	}
	
	
	@KafkaListener(topics = "myfirsttopic", groupId="org.springframework.boot")
	public void receiveMessage(String message) {
		messages.add(message);
	}
	
	@GetMapping("/{message}")
	public List<String> getMessages(){
		return messages;
	}
}