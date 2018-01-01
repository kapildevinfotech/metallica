package com.metallica.mq;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	private final RabbitMessagingTemplate messagingTemplate;

	public Producer(RabbitMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

	public void sendMesage(NotificationType notificationType,String notification) throws Exception {
		Message<String> message = MessageBuilder.withPayload(notification)
		        .setHeader("notification-type", notificationType)
		        .build();
		messagingTemplate.send(RabbitMqApplication.NOTIFICATIONS, message);
	}
}
