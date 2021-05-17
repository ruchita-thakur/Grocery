package com.cg.grocerydeliveryapplication.service;
import java.util.List;
import java.util.Optional;

import com.cg.grocerydeliveryapplication.domain.Cart;
import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.exception.ResourceNotFoundException;

public interface CartService {
	public Cart addToCarts(Cart cart);
	
	public boolean deleteFromCart(int cartId) throws ResourceNotFoundException;
	
	public Cart getCartById(int cartId);
	
	public Cart updateCart(Cart cart, int cartId) throws ResourceNotFoundException;
}
