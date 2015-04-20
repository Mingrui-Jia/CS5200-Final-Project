package com.angular.service;

import com.angular.entity.Book;

public interface IBookManager {

	public void saveBook(Book book);
	public boolean checkBook(Book book);
}
