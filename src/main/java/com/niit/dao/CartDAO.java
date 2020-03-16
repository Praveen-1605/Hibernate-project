package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartDAO
{
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(int id);
	public List<CartItem> displayCartItems(String username);
}
