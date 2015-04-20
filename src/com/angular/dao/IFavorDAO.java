package com.angular.dao;

import com.angular.entity.Favor;

public interface IFavorDAO {
	public void saveFavor(Favor favor);
	public boolean checkFavor(Favor favor);
}
