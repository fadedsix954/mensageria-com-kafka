package com.mensageriakafka.controller;

import com.mensageriakafka.service.NotificationProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificationController {

    @Autowired
    private NotificationProducerService notificationProducerService;

    @PostMapping("/enviar")
    public String sendNotification(@RequestParam String message, @RequestParam String priority) {
        notificationProducerService.sendNotification(message, priority);
        return "Notificação enviada com sucesso!";
    }
}
