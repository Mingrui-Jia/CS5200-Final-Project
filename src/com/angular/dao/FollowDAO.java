package com.angular.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.angular.entity.*;


public class FollowDAO implements IFollowDAO{
	

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public void follow(Follow follow) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
//		要先save这个follow才能从数据库里面取出，直接搞也可以但是delete不行
		s.save(follow);
//		发出follow动作的人
		User user1 = (User)s.get(User.class, follow.getFollow());
		int user1following = user1.getFollowing();
		user1following = user1following + 1;
		user1.setFollowing(user1following);
		s.update(user1);
//		被follow的人
		User user2 = (User)s.get(User.class, follow.getBeingFollowed());
		int user2followed = user2.getFollowed();
		user2followed = user2followed + 1;
		user2.setFollowed(user2followed);
		s.update(user2);
		
		s.getTransaction().commit();
		s.close();
		
	}

	@Override
	@Transactional
	public void unfollow(Follow follow) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
//		发出follow动作的人
		User user1 = (User)s.get(User.class, follow.getFollow());
		int user1following = user1.getFollowing();
		user1following = user1following - 1;
		user1.setFollowing(user1following);
		s.update(user1);
//		被follow的人
		User user2 = (User)s.get(User.class, follow.getBeingFollowed());
		int user2followed = user2.getFollowed();
		user2followed = user2followed - 1;
		user2.setFollowed(user2followed);
		s.update(user2);
		
		s.delete(follow);
		s.getTransaction().commit();
		s.close();
		
	}
	@Override
	public boolean checkFollow(Follow follow) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		Follow follow1=(Follow)s.get(Follow.class, follow);
		
		s.getTransaction().commit();
		return(follow1!=null);
	}


}