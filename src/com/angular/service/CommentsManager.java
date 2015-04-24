package com.angular.service;

import com.angular.dao.ICommentsDAO;

public class CommentsManager implements ICommentsManager {

	private ICommentsDAO commentsDao;


	public ICommentsDAO getCommentsDao() {
		return commentsDao;
	}

	public void setCommentsDao(ICommentsDAO commentsDao) {
		this.commentsDao = commentsDao;
	}

	@Override
	public void saveComments(String bid, String uid, String content) {
		// TODO Auto-generated method stub
		commentsDao.saveComments(bid, uid, content);
		
	}
	
	@Override
	public void deleteComments(int id) {
		// TODO Auto-generated method stub
		commentsDao.deleteComments(id);
		
	}
	
	@Override
	public void updateComments(int id, String content) {
		commentsDao.updateComments(id, content);
	}

	
	

}