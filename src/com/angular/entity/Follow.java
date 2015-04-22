package com.angular.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Follow implements Serializable{
private String follow;
private String beingFollowed;
@Id
public String getFollow() {
	return follow;
}
public void setFollow(String follow) {
	this.follow = follow;
}
@Id
public String getBeingFollowed() {
	return beingFollowed;
}
public void setBeingFollowed(String beingFollowed) {
	this.beingFollowed = beingFollowed;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((beingFollowed == null) ? 0 : beingFollowed.hashCode());
	result = prime * result + ((follow == null) ? 0 : follow.hashCode());
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
	Follow other = (Follow) obj;
	if (beingFollowed == null) {
		if (other.beingFollowed != null)
			return false;
	} else if (!beingFollowed.equals(other.beingFollowed))
		return false;
	if (follow == null) {
		if (other.follow != null)
			return false;
	} else if (!follow.equals(other.follow))
		return false;
	return true;
}
public Follow(String follow, String beingFollowed) {
	super();
	this.follow = follow;
	this.beingFollowed = beingFollowed;
}
public Follow() {
	super();
	// TODO Auto-generated constructor stub
}

}
