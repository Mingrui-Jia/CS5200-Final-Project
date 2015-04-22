package com.angular.dao;

import com.angular.entity.User;

public interface IUserDAO {
	public void saveUser(User user) ;
	public boolean checkUser(User user);
	public boolean checkUserExist(User user);
	public void updateProfile(User user);
}
