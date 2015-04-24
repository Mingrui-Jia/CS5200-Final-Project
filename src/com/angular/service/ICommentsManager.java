package com.angular.service;


public interface ICommentsManager {

	public void updateComments(int id, String content);
	public void deleteComments(int id);
	public void saveComments(String bid, String uid, String content);
}