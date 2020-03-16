package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.dao.CartDAO;
import com.niit.dbconfig.HibernateUtil;
import com.niit.model.CartItem;

public class CartDAOImpl implements CartDAO
{

	public boolean addCartItem(CartItem cartItem) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(cartItem);
		tx.commit();
		return true;
	}

	public boolean deleteCartItem(int id) 
	{
		CartItem cartItem=new CartItem();
		cartItem.setCartitemid(id);
		
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.delete(cartItem);
		tx.commit();
		return true;
	}

	public List<CartItem> displayCartItems(String username) 
	{
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from com.niit.model.CartItem where user.username= :uname");
		query.setParameter("uname", username);
		return query.getResultList();
	}
}

