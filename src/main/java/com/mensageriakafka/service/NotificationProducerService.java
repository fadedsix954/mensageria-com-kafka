package com.mensageriakafka.service;

import com.mensageriakafka.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducerService {

    private static final String TOPIC = "notificacoes";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendNotification(String message, String priority) {
        Notification notification = new Notification(message, priority);
        kafkaTemplate.send(TOPIC, notification.getPriority() + ": " + notification.getMessage());
        System.out.println("Notificação enviada: " + notification.getMessage() + " com prioridade: " + notification.getPriority());
    }
}
