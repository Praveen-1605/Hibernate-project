package com.niit.dao;

import java.util.List;

import com.niit.model.Watch;

public interface WatchDAO 
{
	public boolean addWatch(Watch watch);
	public boolean deleteWatch(int watchid);
	public boolean updateWatch(Watch watch);
	public List<Watch> displayWatches();
	public Watch displayWatchById(int watchid);
	public List<Watch> displayWatchByName(String watchname);
	public List<Watch> displayWatchByPriceHighToLow();
	public List<Watch> displayWatchByPriceLowToHigh();
}