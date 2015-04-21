package com.angular.service;

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
}
