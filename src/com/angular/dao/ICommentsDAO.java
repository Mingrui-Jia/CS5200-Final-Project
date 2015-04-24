package com.angular.dao;

import com.angular.entity.*;


public interface ICommentsDAO {


	public void updateComments(int id, String content);
	public void saveComments(String bid, String uid, String content);
	public void deleteComments(int id);
}