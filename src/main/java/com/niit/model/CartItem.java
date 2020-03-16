  
package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartitems")
public class CartItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartitemid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Watch watch;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;


	public int getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
