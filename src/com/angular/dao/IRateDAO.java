package com.angular.dao;

import java.util.List;

public interface IRateDAO {
	public List<String> findRatedBookByUser(String username);
	public List<String> findUserByRatedBook(String bookid);
//	public void saveRate(Rate rate);
//	public void deleteRate(Rate rate);
//	public boolean checkRate(Rate rate);
	public void updateRate(String bid, String uid, int ratevalue);
//	public void saveRate(ratePK ratePK, int ratevalue);
	public void saveRate(String bid, String uid, int ratevalue);
	public boolean checkRate(String bid, String uid);
}