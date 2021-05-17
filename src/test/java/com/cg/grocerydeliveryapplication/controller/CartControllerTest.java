package com.cg.grocerydeliveryapplication.controller;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import com.cg.grocerydeliveryapplication.domain.Cart;
import com.cg.grocerydeliveryapplication.service.CartServiceImpl;
import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;







@SpringBootTest
class CartControllerTest {
	
	
	
	@InjectMocks
	CartController cartController;

	@Mock
	CartServiceImpl cartService;

	@MockBean
	private BindingResult bindingResult;
	
	@Mock
	private MapValidationErrorService mapValidateErrorService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddFoodCart() throws Exception {

		Cart cart = getCart();
		Mockito.when(cartService.addToCarts(cart)).thenReturn(cart);
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);
		//Mockito.when(mapValidateErrorService.mapValidationError(bindingResult)).thenReturn(null);
		ResponseEntity<?> ctg = cartController.addFoodCart(cart, bindingResult);
		assertThat(ctg.getStatusCodeValue()).isEqualTo(201);

		

		
	}
	
	@Test
	void getCartByIdTest() {
		Cart cart=getCart();
		Integer cartId=cart.getCartId();
		Mockito.when(cartService.getCartById(cartId)).thenReturn(cart);
		ResponseEntity<?> responseEntity = cartController.getCartById(cartId);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		
		
	}

	@Test
	void testDeleteFoodCart() {
		
		
		Cart cart=new Cart(6,null);
		Mockito.when(cartService.getCartById(6)).thenReturn(cart);
		Mockito.doReturn(true).when(cartService).deleteFromCart(6);
		cartController.deleteFoodCart(6);
		assertDoesNotThrow(()->cartController.deleteFoodCart(6));
		
		
	}


	
	private Cart getCart() {

		Cart cart=new Cart();
		cart.setCartId(3);
		return cart;
		
	}
	
	
	

	


}
