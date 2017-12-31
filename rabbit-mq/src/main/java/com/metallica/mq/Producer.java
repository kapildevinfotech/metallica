package com.metallica.mq;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	private final RabbitMessagingTemplate messagingTemplate;

	public Producer(RabbitMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

	public void sendMesage(NotificationType notificationType,String message) throws Exception {
		Message AMQPmessage = new Message(UUID.randomUUID().toString(),notificationType,
				message, new Date());

		Map<String, Object> headers = new HashMap<>();
		headers.put("notification-id", AMQPmessage.getId());

		this.messagingTemplate.convertAndSend(RabbitMqApplication.NOTIFICATIONS,
				AMQPmessage, headers, messageTxt -> {
					System.out.println("sending " + messageTxt.getPayload().toString());
					return messageTxt;
				});
	}
}
