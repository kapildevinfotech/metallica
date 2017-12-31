package com.metallica.mq;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private NotificationType notificationType;
	private final String message;

	private final Date date;

	public Message(String id,NotificationType notificationType, String message, Date date) {
		this.id = id;
		this.notificationType=notificationType;
		this.message = message;
		this.date = date;
	}

	public String getId() {
		return id;
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
		return "Notification {notificationType" + notificationType + " message='" + message + '\'' + ", date=" + date + '}';
	}

}
