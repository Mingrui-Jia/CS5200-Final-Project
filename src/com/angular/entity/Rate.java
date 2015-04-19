package com.angular.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
@Entity
public class Rate {
private String bid;
private String uid;
private double rate;
private Date rateDateTime;
@Id
public String getBid() {
	return bid;
}
public void setBid(String bid) {
	this.bid = bid;
}
@Id
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public double getRate() {
	return rate;
}
public void setRate(double rate) {
	this.rate = rate;
}
public Date getRateDateTime() {
	return rateDateTime;
}
public void setRateDateTime(Date rateDateTime) {
	this.rateDateTime = rateDateTime;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bid == null) ? 0 : bid.hashCode());
	long temp;
	temp = Double.doubleToLongBits(rate);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result
			+ ((rateDateTime == null) ? 0 : rateDateTime.hashCode());
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
	Rate other = (Rate) obj;
	if (bid == null) {
		if (other.bid != null)
			return false;
	} else if (!bid.equals(other.bid))
		return false;
	if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
		return false;
	if (rateDateTime == null) {
		if (other.rateDateTime != null)
			return false;
	} else if (!rateDateTime.equals(other.rateDateTime))
		return false;
	if (uid == null) {
		if (other.uid != null)
			return false;
	} else if (!uid.equals(other.uid))
		return false;
	return true;
}
public Rate(String bid, String uid, double rate, Date rateDateTime) {
	super();
	this.bid = bid;
	this.uid = uid;
	this.rate = rate;
	this.rateDateTime = rateDateTime;
}
public Rate() {
	super();
	// TODO Auto-generated constructor stub
}

}
