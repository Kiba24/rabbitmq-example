
# Rabbit MQ Scaffolding

Simple example of an idea of a rabbitmq scaffold, i'm gonna use this as a sketch for one of my college projects.

There are two simple senders and one unique reciever, the reciever gonna act different based on the headers of the recieved message.



## Initialize Rabbit server

```javascript
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

### Endpoint
I made two GET endpoints /send-a & /send-b which automatically adds the correspondant header to the message and the queryParam ?message will be treated as a body 

### Sending message from service A

GET http://localhost:8080/send-a?message=ThisIsAMessage

### Sending message from service B

GET http://localhost:8080/send-b?message=ThisIsAMessage
