package com.angular.service;

import java.util.List;

import com.angular.entity.User;

public interface IUserManager {

	public void saveUser(User user);
	public boolean checkUser(User user);
	public boolean checkUserExist(User user);
	public void updateProfile(User user);
	public List<String> findFollowedByUser(String username);
	public List<String> findFollowingByUser(String username);
	public User findUserByUsername(String username);
}

