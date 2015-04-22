package com.angular.entity;

import java.io.Serializable;


public class ratePK implements Serializable{
private String uid;
private String bid;
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getBid() {
	return bid;
}
public void setBid(String bid) {
	this.bid = bid;
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
	ratePK other = (ratePK) obj;
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
public ratePK(String uid, String bid) {
	super();
	this.uid = uid;
	this.bid = bid;
}
public ratePK() {
	super();
	// TODO Auto-generated constructor stub
}

}