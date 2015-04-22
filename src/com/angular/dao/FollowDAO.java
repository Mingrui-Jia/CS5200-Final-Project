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
		System.out.println("dao");
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(follow);
		s.getTransaction().commit();
		s.close();
		
	}

	@Override
	@Transactional
	public void unfollow(Follow follow) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
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