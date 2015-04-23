package com.angular.service;

import java.util.List;

import com.angular.dao.IUserDAO;
import com.angular.entity.User;

public class UserManager implements IUserManager {

	
	private IUserDAO userDao;
	
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub

		userDao.saveUser(user);
	}
	@Override
	public boolean checkUser(User user) {
		//System.out.println(user.getUserName());
		// TODO Auto-generated method stub
		return userDao.checkUser(user);
	}

	@Override
	public boolean checkUserExist(User user){
		return userDao.checkUserExist(user);
	}
	@Override
	public void updateProfile(User user) {
		
		userDao.updateProfile(user);
	}
//	20150423-11:00
	@Override
	public List<String> findFollowedByUser(String username) {
		 return userDao.findFollowedByUser(username);
	}
//	20150423-11:00
	@Override
	public List<String> findFollowingByUser(String username) {
		return userDao.findFollowingByUser(username);
	}
//	20150423-11:00
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
}
