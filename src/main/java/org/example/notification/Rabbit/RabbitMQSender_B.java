package org.example.notification.Rabbit;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender_B {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        Message notification = MessageBuilder.withBody(message.getBytes())
                .setHeader("source", "Service B")
                .build();
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE,RabbitConfiguration.ROUTING_KEY, notification);
    }
}