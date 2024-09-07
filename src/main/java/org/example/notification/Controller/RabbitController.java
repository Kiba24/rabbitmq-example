package org.example.notification.Controller;

import org.example.notification.Rabbit.RabbitMQSender_A;
import org.example.notification.Rabbit.RabbitMQSender_B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private RabbitMQSender_A rabbitMQSender_a;
    @Autowired
    private RabbitMQSender_B rabbitMQSender_b;

    @GetMapping("/send-a")
    public String sendMessageFromA(@RequestParam String message) {
        rabbitMQSender_a.send(message);
        return "Message sent: " + message;
    }

    @GetMapping("/send-b")
    public String sendMessageFromB(@RequestParam String message) {
        rabbitMQSender_b.send(message);
        return "Message sent: " + message;
    }
}
