package com.mensageriakafka.consumer;

import com.mensageriakafka.model.Notification;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class NotificationConsumer {

    private static final Logger logger = Logger.getLogger(NotificationConsumer.class.getName());

    // Lista temporária para armazenamento de notificações de baixa prioridade
    private List<Notification> batchNotifications = new ArrayList<>();
    private static final int BATCH_SIZE = 5;  // Define o tamanho do lote para envio em grupo

    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void consumeNotifications(List<ConsumerRecord<String, Notification>> records) {
        for (ConsumerRecord<String, Notification> record : records) {
            Notification notification = record.value();

            if (notification.getPriority().equalsIgnoreCase("high")) {
                // Envio imediato para notificações de alta prioridade
                sendNotification(notification);
            } else {
                // Armazena notificações de baixa prioridade para envio em lote
                batchNotifications.add(notification);

                if (batchNotifications.size() >= BATCH_SIZE) {
                    // Envia o lote de notificações
                    sendBatchNotifications();
                    batchNotifications.clear(); // Limpa a lista após envio
                }
            }
        }
    }

    private void sendNotification(Notification notification) {
        // Lógica de envio de notificação individual
        logger.info(String.format("Enviando notificação imediata para %s: %s", notification.getUserType(), notification.getMessage()));
    }

    private void sendBatchNotifications() {
        // Lógica de envio de notificação em lote
        logger.info("Enviando lote de notificações (Baixa prioridade):");
        batchNotifications.forEach(notification -> logger.info(String.format("Notificação para %s: %s", notification.getUserType(), notification.getMessage())));
    }
}
