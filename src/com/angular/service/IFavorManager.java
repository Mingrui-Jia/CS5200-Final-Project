package com.angular.service;

import com.angular.entity.Favor;

public interface IFavorManager {

	public void saveFavor(Favor favor);
	public boolean checkFavor(Favor favor);
}
