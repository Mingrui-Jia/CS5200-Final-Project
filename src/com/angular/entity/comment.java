package com.angular.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class comment {
private int id;
private String bid;
private String uid;
private String comment;
private Date commentDateTime;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBid() {
	return bid;
}
public void setBid(String bid) {
	this.bid = bid;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Date getCommentDateTime() {
	return commentDateTime;
}
public void setCommentDateTime(Date commentDateTime) {
	this.commentDateTime = commentDateTime;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bid == null) ? 0 : bid.hashCode());
	result = prime * result + ((comment == null) ? 0 : comment.hashCode());
	result = prime * result
			+ ((commentDateTime == null) ? 0 : commentDateTime.hashCode());
	result = prime * result + id;
	result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
	comment other = (comment) obj;
	if (bid == null) {
		if (other.bid != null)
			return false;
	} else if (!bid.equals(other.bid))
		return false;
	if (comment == null) {
		if (other.comment != null)
			return false;
	} else if (!comment.equals(other.comment))
		return false;
	if (commentDateTime == null) {
		if (other.commentDateTime != null)
			return false;
	} else if (!commentDateTime.equals(other.commentDateTime))
		return false;
	if (id != other.id)
		return false;
	if (uid == null) {
		if (other.uid != null)
			return false;
	} else if (!uid.equals(other.uid))
		return false;
	return true;
}
public comment(int id, String bid, String uid, String comment,
		Date commentDateTime) {
	super();
	this.id = id;
	this.bid = bid;
	this.uid = uid;
	this.comment = comment;
	this.commentDateTime = commentDateTime;
}
public comment() {
	super();
	// TODO Auto-generated constructor stub
}


}
