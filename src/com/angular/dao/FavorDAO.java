package com.angular.dao;

import java.util.List;



import org.hibernate.Query;
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
//	4.20 20：28
//	注意此处HQL和传递参数的格式，只能用hibernate的query，与EclipseLink中不同
//	@RequestMapping(value="/findFavoriteBookByUser/{username}")
//	favor.userID和favor.bookID要注意和数据库中的属性名字一致，注意大小写
	@Override
	public List<String> findFavoriteBookByUser(String userid) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		String hql = "select favor.bookID "
				+ "from Favor favor "
				+ "where favor.userID=" + "'"+userid+"'";
		Query query = s.createQuery(hql);
		return (List<String>)query.list();
		

	}
	
	@Override
	public List<String> findUserByFavoriteBook(String bookid) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		String hql = "select favor.userID "
				+ "from Favor favor "
				+ "where favor.bookID=" + "'"+bookid+"'";
		Query query = s.createQuery(hql);
		return (List<String>)query.list();
	}

	@Override
	@Transactional
	public void deleteFavor(Favor favor) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(favor);
		s.getTransaction().commit();
		s.close();
		
	}
}
