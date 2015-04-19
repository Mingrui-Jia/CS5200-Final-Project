package com.angular.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favorite {
private Book bid;
private User uid;
@Id
public Book getBid() {
	return bid;
}
public void setBid(Book bid) {
	this.bid = bid;
}
@Id
public User getUid() {
	return uid;
}
public void setUid(User uid) {
	this.uid = uid;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bid == null) ? 0 : bid.hashCode());
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
	Favorite other = (Favorite) obj;
	if (bid == null) {
		if (other.bid != null)
			return false;
	} else if (!bid.equals(other.bid))
		return false;
	if (uid == null) {
		if (other.uid != null)
			return false;
	} else if (!uid.equals(other.uid))
		return false;
	return true;
}
public Favorite(Book bid, User uid) {
	super();
	this.bid = bid;
	this.uid = uid;
}
public Favorite() {
	super();
	// TODO Auto-generated constructor stub
}

}
