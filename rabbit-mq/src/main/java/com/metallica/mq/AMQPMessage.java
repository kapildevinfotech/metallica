package com.metallica.mq;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AMQPMessage implements Serializable {
	
	private NotificationType notificationType;
	private final String message;
	private final Date date;

	public AMQPMessage(NotificationType notificationType, String message, Date date) {
		this.notificationType=notificationType;
		this.message = message;
		this.date = date;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}
	
	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		String json=null;
		try {
			json=toJson();
		} catch (JsonProcessingException e) {
			json="Notification{ Notificationtype "+notificationType + "message='" + message + '\'' + ", date=" + date + '}';
		}
		return json;
	}
	
	public String toJson() throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(this);
	}
}
