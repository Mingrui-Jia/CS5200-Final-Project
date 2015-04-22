package com.angular.dao;



import java.util.List;

import com.angular.entity.Favor;

public interface IFavorDAO {
	public void saveFavor(Favor favor);
	public boolean checkFavor(Favor favor);
	public List<String> findFavoriteBookByUser(String username);
	public List<String> findUserByFavoriteBook(String bookid);
	public void deleteFavor(Favor favor);
}
