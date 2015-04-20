package com.angular.dao;

import com.angular.entity.Book;

public interface IBookDAO {
	public void saveBook(Book book);
	public boolean checkBook(Book book);
}
