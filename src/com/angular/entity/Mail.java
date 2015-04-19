package com.angular.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Mail {
private int id;
private User sender;
private User reciever;
private String title;
private String content;
private Date sendDateTime;
private Mail reply;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public User getSender() {
	return sender;
}
public void setSender(User sender) {
	this.sender = sender;
}
public User getReciever() {
	return reciever;
}
public void setReciever(User reciever) {
	this.reciever = reciever;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getSendDateTime() {
	return sendDateTime;
}
public void setSendDateTime(Date sendDateTime) {
	this.sendDateTime = sendDateTime;
}
public Mail getReply() {
	return reply;
}
public void setReply(Mail reply) {
	this.reply = reply;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((content == null) ? 0 : content.hashCode());
	result = prime * result + id;
	result = prime * result + ((reciever == null) ? 0 : reciever.hashCode());
	result = prime * result + ((reply == null) ? 0 : reply.hashCode());
	result = prime * result
			+ ((sendDateTime == null) ? 0 : sendDateTime.hashCode());
	result = prime * result + ((sender == null) ? 0 : sender.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Mail other = (Mail) obj;
	if (content == null) {
		if (other.content != null)
			return false;
	} else if (!content.equals(other.content))
		return false;
	if (id != other.id)
		return false;
	if (reciever == null) {
		if (other.reciever != null)
			return false;
	} else if (!reciever.equals(other.reciever))
		return false;
	if (reply == null) {
		if (other.reply != null)
			return false;
	} else if (!reply.equals(other.reply))
		return false;
	if (sendDateTime == null) {
		if (other.sendDateTime != null)
			return false;
	} else if (!sendDateTime.equals(other.sendDateTime))
		return false;
	if (sender == null) {
		if (other.sender != null)
			return false;
	} else if (!sender.equals(other.sender))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
public Mail(int id, User sender, User reciever, String title, String content,
		Date sendDateTime, Mail reply) {
	super();
	this.id = id;
	this.sender = sender;
	this.reciever = reciever;
	this.title = title;
	this.content = content;
	this.sendDateTime = sendDateTime;
	this.reply = reply;
}
public Mail() {
	super();
	// TODO Auto-generated constructor stub
}

}
