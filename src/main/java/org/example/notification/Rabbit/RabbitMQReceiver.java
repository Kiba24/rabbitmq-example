package org.example.notification.Rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;

@Component
public class RabbitMQReceiver {
    @RabbitListener(queues = RabbitConfiguration.QUEUE)
    public void receiveMessage(Message message) {
        String source = (String) message.getMessageProperties().getHeaders().get("source");
        System.out.println("Received message from" + source+ " : "+message.getBody().toString());
    }
}

