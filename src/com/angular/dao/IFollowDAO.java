package com.angular.dao;

import com.angular.entity.Book;
import com.angular.entity.Follow;

public interface IFollowDAO {

	public void follow(Follow follow);

	public void unfollow(Follow follow);

	public boolean checkFollow(Follow follow);
}
