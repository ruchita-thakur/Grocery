package com.cg.grocerydeliveryapplication.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocerydeliveryapplication.domain.Cart;
import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.domain.User;
import com.cg.grocerydeliveryapplication.exception.ResourceNotFoundException;
import com.cg.grocerydeliveryapplication.repository.CartRepository;
import com.cg.grocerydeliveryapplication.repository.ProductRepository;
import com.cg.grocerydeliveryapplication.repository.UserRepository;



@Service

public class CartServiceImpl implements CartService {
	
	

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addToCarts(Cart cart) {
		return cartRepository.save(cart);
		
	}

	@Override
	public boolean deleteFromCart(int cartId) throws ResourceNotFoundException{
		
		Cart cart=cartRepository.findByCartId(cartId);
		cartRepository.deleteById(cartId);		
				return true;
	}

	
	
	public Cart updateCart(Cart cart, int cartId) throws ResourceNotFoundException{
		
		Cart cart1 = cartRepository.findByCartId(cartId);
		cart.setCartId(cart1.getCartId());
		final Cart updatedcart= cartRepository.save(cart);
		return updatedcart;
	}


//	@Override
//	public Cart getCartById(int cartId) {
//		Optional<Cart> optional=cartRepository.findById(cartId);
//		if(optional.isPresent()) {
//			return optional.get();
//		}
//		
//		return null;
//	}
//	
//	public Cart getCartById(long id) {
//		Admin a = sr.findAdminById(id);
//		
//		if(a == null) {
//			 new ResourceNotFoundException("Admn not found for this id :: "+ id);
//		}
//		return a;
//	}
	@Override
	public Cart getCartById(int cartId) {
	Cart cart=cartRepository.findByCartId(cartId);
	return cart;
}
	

	

	

	
	}
