package com.niit.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.niit.daoimpl.WatchDAOImpl;
import com.niit.daoimpl.CartDAOImpl;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.Watch;
import com.niit.model.CartItem;
import com.niit.model.User;

public class CartTest
{
	CartDAOImpl cdi=new CartDAOImpl();
	UserDAOImpl udi=new UserDAOImpl();
	WatchDAOImpl bdi=new WatchDAOImpl();
	
	@Test
	@Ignore
	public void addCartItem()
	{
		CartItem c=new CartItem();
		
		User u=udi.displayUserById(5);
		Watch b=bdi.displayWatchById(4);
		
		c.setUser(u);
		c.setWatch(w);
		cdi.addCartItem(c);
	}
	
	@Test
	public void displayCartItemsByName()
	{
		List<CartItem> cartItems=cdi.displayCartItems("Govind123");
		
		for(CartItem c:cartItems)
		{
			System.out.println(c.getCartitemid());
			System.out.println(c.getWatch().getWatchid());
			System.out.println(c.getWatch().getWatchname());
			System.out.println(c.getUser().getUsername());
		}
	}
	
	
}