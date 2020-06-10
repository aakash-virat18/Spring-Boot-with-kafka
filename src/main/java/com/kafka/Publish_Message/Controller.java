package com.kafka.Publish_Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class Controller {


    @Autowired
    KafkaTemplate<String,String>  kafkaTemplate;
    static final String TOPIC = "gfg";

    @GetMapping("publish/{message}")
    public String publish_message(@PathVariable("message") String message)
    {
        kafkaTemplate.send(TOPIC,message);
        return "Message Published on Kafka !";
    }
}
