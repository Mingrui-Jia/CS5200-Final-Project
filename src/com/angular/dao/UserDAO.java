package com.angular.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.angular.entity.Follow;
import com.angular.entity.User;


public class UserDAO implements IUserDAO {

	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public void saveUser(User user) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
		s.close();
		
//		
//		sessionFactory.getCurrentSession().save(user);
//		
//		Session s=sessionFactory.getCurrentSession();
//		s.beginTransaction();
//		
//		s.save(user);
//		s.getTransaction().commit();
		
	}
//	20150423-11:00
	@Override
	@Transactional
//	被谁follow
	public List<String> findFollowedByUser(String username) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
//		得到follow实体的list，没有数字的ID，麻烦！
		List<Follow> follows = new ArrayList<Follow>();
		String hql1 = "select follow from Follow follow";
		Query query1 = s.createQuery(hql1);
		follows = (List<Follow>)query1.list();
		List<String> resultsList = new ArrayList<String>();
		for (Follow follow :follows) {
			
			if (follow.getBeingFollowed().equals(username)) {
				System.out.println(follow.getFollow());
				resultsList.add(follow.getFollow());
			}
		}
		
		s.getTransaction().commit();

		return resultsList;
	}
	
//	20150423-11:00
	@Override
	@Transactional
//	follow的人
	public List<String> findFollowingByUser(String username) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
//		得到follow实体的list，没有数字的ID，麻烦！
		List<Follow> follows = new ArrayList<Follow>();
		String hql1 = "select follow from Follow follow";
		Query query1 = s.createQuery(hql1);
		follows = (List<Follow>)query1.list();
		List<String> resultsList = new ArrayList<String>();
		for (Follow follow :follows) {
			if (follow.getFollow().equals(username)) {
				resultsList.add(follow.getBeingFollowed());
			}
		}
		
		s.getTransaction().commit();

		return resultsList;
	}
	
//	20150423-11:00
	@Override
	@Transactional
	public User findUserByUsername(String username) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		User user = (User) s.get(User.class, username);
		s.getTransaction().commit();
		//s.close();
		return user;
	}
	@Override
	@Transactional
	public boolean checkUser(User user) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		
		
		User user1= (User)s.load(User.class,user.getUserName());
		s.getTransaction().commit();
		
//		System.out.println(user1.getUserName());
//		System.out.println(user1.getPassword());
//		System.out.println(user.getPassword());
		if(user1.getPassword().equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
		
	}
	
	@Override
	public boolean checkUserExist(User user) {
		
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		User user1=(User)s.get(User.class, user.getUserName());
		
		s.getTransaction().commit();
		return(user1!=null);
	}
//	4.21 13£º00
	public void updateProfile(User user) {
//		, String password, String firstName, String lastName, String email, String phoneNumber
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		User user1=(User)s.get(User.class, user.getUserName());
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
		String phoneNumber = user.getPhoneNumber();
		user1.setPassword(password);
		user1.setFirstName(firstName);
		user1.setLastName(lastName);
		user1.setEmail(email);
		user1.setPhoneNumber(phoneNumber);
		s.update(user1);
//		s.merge(user1);
		s.getTransaction().commit();
		s.close();
	}
	
}
