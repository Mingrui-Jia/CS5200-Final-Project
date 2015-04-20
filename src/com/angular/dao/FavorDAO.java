package com.angular.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import com.angular.entity.Favor;

public class FavorDAO implements IFavorDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public void saveFavor(Favor favor) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(favor);
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
	public boolean checkFavor(Favor favor) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		Favor book1=(Favor)s.get(Favor.class, favor);
		
		s.getTransaction().commit();
		return(book1!=null);
	}

}
