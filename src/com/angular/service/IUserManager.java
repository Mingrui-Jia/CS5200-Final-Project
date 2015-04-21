package com.angular.service;

import com.angular.entity.User;

public interface IUserManager {

	public void saveUser(User user);
	public boolean checkUser(User user);
	public boolean checkUserExist(User user);
}

