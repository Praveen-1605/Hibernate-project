package com.niit.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;

public class UserTest 
{
	UserDAOImpl udi=new UserDAOImpl();
	
	@Test
	public void addUser()
	{
		User u=new User();
		u.setUsername("Govind123");
		u.setEmail("Govind123@gmail.com");
		u.setPassword("Pass@123");
		udi.addUser(u);
	}

	@Test
	@Ignore
	public void deleteUser()
	{
		udi.deleteUser(1);
	}
	
	@Test
	@Ignore
	public void updateUser()
	{
		User u=udi.displayUserById(2);
		u.setEmail("Govind@gmail.com");
		udi.updateUser(u);
	}
	
	@Test
	@Ignore
	public void displayUserById()
	{
		assertNotEquals(null, udi.displayUserById(5));
	}
	
	@Test
	@Ignore
	public void displayUsers()
	{
		assertNotEquals(null, udi.displayUsers());
	}
	
	
	
}