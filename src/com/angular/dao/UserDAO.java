package com.angular.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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
