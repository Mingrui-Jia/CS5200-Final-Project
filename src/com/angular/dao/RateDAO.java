package com.angular.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import com.angular.entity.*;




public class RateDAO implements IRateDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
//	update的时候在controller里面调用这个方法
	public void updateRate(String bid, String uid, int ratevalue) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		ratePK ratePK = new ratePK();
		ratePK.setBid(bid);
		ratePK.setUid(uid);
		Rate rate=(Rate)s.get(Rate.class, ratePK);
		rate.setRate(ratevalue);
		rate.setRateDateTime(new Date());
		s.update(rate);
		s.getTransaction().commit();
		s.close();
	}
	
	@Override
	@Transactional
//	到时候打包传进来？或者传pk。时间就用当前时间
	public void saveRate(String bid, String uid, int ratevalue) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		Rate rate = new Rate();
		rate.setBid(bid);
		rate.setUid(uid);
		rate.setRate(ratevalue);
		rate.setRateDateTime(new Date());
		s.save(rate);
		s.getTransaction().commit();
		s.close();
	}
	
//	@Override
//	@Transactional
////	到时候打包传进来？或者传pk。时间就用当前时间
//	public void saveRate(Rate rate) {
//		Session s=sessionFactory.openSession();
//		s.beginTransaction();
//		s.save(rate);
//		s.getTransaction().commit();
//		s.close();
//	}
	

//	return1表示这个book在rate表中存在
//	这里似乎加一个rate的PK比较好，再看
	@Override
	public boolean checkRate(String bid, String uid) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		ratePK ratePK = new ratePK();
		ratePK.setBid(bid);
		ratePK.setUid(uid);
		Rate rate=(Rate)s.get(Rate.class, ratePK);
	
		s.getTransaction().commit();
		return(rate!=null);
	}
	

//	注意此处HQL和传递参数的格式，只能用hibernate的query，与EclipseLink中不同
//	@RequestMapping(value="/findFavoriteBookByUser/{username}")
//	favor.userID和favor.bookID要注意和数据库中的属性名字一致，注意大小写
	@Override
	public List<String> findRatedBookByUser(String userid) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		String hql = "select rate.bid "
				+ "from Rate rate "
				+ "where rate.uid=" + "'"+userid+"'";
		Query query = s.createQuery(hql);
		return (List<String>)query.list();
		
//		List<String> bookIdList = new ArrayList();
//		for (Book book : books) {
//			bookIdList.add(book.getId());
//		}
//		
//		return bookIdList;
	}
	
	@Override
	public List<String> findUserByRatedBook(String bookid) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		String hql = "select rate.uid "
				+ "from Rate rate "
				+ "where rate.bid=" + "'"+bookid+"'";
		Query query = s.createQuery(hql);
		return (List<String>)query.list();
	}

}