package com.angular.service;

import com.angular.dao.FollowDAO;
import com.angular.dao.IFollowDAO;
import com.angular.entity.Follow;

public class FollowManager implements IFollowManager {

	private IFollowDAO followDao;



	public IFollowDAO getFollowDao() {
		return followDao;
	}

	public void setFollowDao(IFollowDAO followDao) {
		this.followDao = followDao;
	}

	@Override
	public void saveFollow(Follow follow) {
		System.out.println("manager");
		followDao.follow(follow);
		
	}
	
	@Override
	public void deleteFollow(Follow follow) {
		// TODO Auto-generated method stub
		followDao.unfollow(follow);
		
	}

	@Override
	public boolean checkFollow(Follow follow) {
		System.out.println("manager");
		return followDao.checkFollow(follow);
	}
	
}