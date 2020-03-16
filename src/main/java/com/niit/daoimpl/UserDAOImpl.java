package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.niit.dao.UserDAO;
import com.niit.dbconfig.HibernateUtil;
import com.niit.model.User;

public class UserDAOImpl implements UserDAO
{
	public boolean addUser(User user)
	{
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setAuthority("user");
		user.setEnabled(true);
		
		Session session=HibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		session.save(user);
		tx.commit();
		return true;
	}

	public boolean deleteUser(int userid) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		
		User user=new User();
		user.setUserid(userid);
		session.delete(user);
		tx.commit();
		
		return true;
	}

	public boolean updateUser(User user) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		session.update(user);
		tx.commit();
		return true;
	}

	public List<User> displayUsers() 
	{
		Session session=HibernateUtil.getSession();
		return session.createQuery("from com.niit.model.User").list();
	}

	public User displayUserById(int userid) 
	{
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from com.niit.model.User where userid= :uid");
		query.setParameter("uid", userid);
		return (User)query.getResultList().get(0);
	}

	public User displayUserByName(String username) 
	{
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery("from com.niit.model.User where username= :username");
		query.setParameter("username", username);
		return (User)query.getResultList().get(0);
	}
}