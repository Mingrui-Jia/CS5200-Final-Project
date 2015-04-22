package com.angular.service;

import java.util.List;

import com.angular.dao.IRateDAO;


public class RateManager implements IRateManager {

	private IRateDAO rateDao;
	public IRateDAO getRateDao() {
		return rateDao;
	}

	public void setRateDao(IRateDAO rateDao) {
		this.rateDao = rateDao;
	}

	
	@Override
	public List<String> findRatedBookByUser(String username) {
		return rateDao.findRatedBookByUser(username);
	}
	@Override
	public List<String> findUserByRatedBook(String bookid) {
		return rateDao.findUserByRatedBook(bookid);
	}
	@Override
	public void updateRate(String bid, String uid, int ratevalue) {
		rateDao.updateRate(bid, uid, ratevalue);
	}
	@Override
	public void saveRate(String bid, String uid, int ratevalue) {
		rateDao.saveRate(bid, uid, ratevalue);
	}
	@Override
	public boolean checkRate(String bid, String uid) {
		return rateDao.checkRate(bid, uid);
	}
	
	

}