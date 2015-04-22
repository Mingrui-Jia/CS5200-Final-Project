package com.angular.service;

import java.util.List;


public interface IRateManager {

	List<String> findRatedBookByUser(String username);

	List<String> findUserByRatedBook(String bookid);

	void updateRate(String bid, String uid, int ratevalue);

	void saveRate(String bid, String uid, int ratevalue);

	boolean checkRate(String bid, String uid);


}