package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.dao.WatchDAO;
import com.niit.dbconfig.HibernateUtil;
import com.niit.model.Watch;

public class WatchDAOImpl implements WatchDAO
{

	public boolean addWatch(Watch watch)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(watch);
		tx.commit();
		return true;
	}

	public boolean deleteWatch(int watchid) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
	    Watch watch=new Watch();
		watch.setWatchid(watchid);
		session.delete(watch);
		tx.commit();
		return true;
	}

	public boolean updateWatch(Watch watch) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.update(watch);
		tx.commit();
		return true;
	}

	public List<Watch> displayWatches()
	{
		Session session=HibernateUtil.getSession();
		return session.createQuery("from com.niit.model.Watch").list();
	}

	public Watch displayWatchById(int watchid) 
	{
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from com.niit.model.Watch where watchid= :wid");
		query.setParameter("wid", watchid);
		return (Watch)query.getResultList().get(0);
	}

	public List<Watch> displayWatchByName(String watchname) {
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from com.niit.model.Watch where watchname like :name");
		query.setParameter("name", "%"+watchname+"%");
		return query.getResultList();
	}

	public List<Watch> displayWatchByPriceHighToLow() {
		Session session=HibernateUtil.getSession();
		return session.createQuery("from com.niit.model.Watch order by price desc").getResultList();
	}

	public List<Watch> displayWatchByPriceLowToHigh() {
		Session session=HibernateUtil.getSession();
		return session.createQuery("from com.niit.model.Watch order by price asc").getResultList();
		
	}
}
