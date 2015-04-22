package com.angular.service;

import com.angular.entity.Follow;

public interface IFollowManager {

	void saveFollow(Follow follow);

	void deleteFollow(Follow follow);
	
	boolean checkFollow(Follow follow);
}