package com.cg.grocerydeliveryapplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.grocerydeliveryapplication.domain.Cart;
import com.cg.grocerydeliveryapplication.domain.Category;
import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.repository.CartRepository;
import com.cg.grocerydeliveryapplication.repository.ProductRepository;





@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(value = CartService.class)
class CartServiceTest {
	
	@Autowired
	private CartService cartService;
	
	@MockBean
	private CartRepository cartRepository;
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock 
	private ProductService productService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddToCarts() {
		Cart addcart=getCart();
		Mockito.when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(addcart);
		Cart result=cartService.addToCarts(addcart);
		assertThat(addcart).isEqualTo(result);
	}

	@Test
	void testDeleteFromCart() {
		Cart c=getCart();
		boolean b=true;
		Mockito.when(cartRepository.findByCartId(Mockito.anyInt())).thenReturn(c);
		doNothing().when(cartRepository).deleteById(Mockito.anyInt());
		boolean result=cartService.deleteFromCart(1);
		assertThat(b).isEqualTo(result);
		

	}

	@Test
	void testUpdateCart() {

		Cart cart1 = getCart();
		Mockito.when(cartRepository.findByCartId(Mockito.anyInt())).thenReturn(cart1);
		Mockito.when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart1);
		Cart result=cartService.updateCart(cart1, 1);
		assertThat(cart1).isEqualTo(result);
		
	}

	@Test
	void testGetCartById() {

		Cart cart=getCart();
		Mockito.when(cartRepository.findByCartId(Mockito.anyInt())).thenReturn(cart);
		Cart result=cartService.getCartById(1);
		assertThat(cart).isEqualTo(result);
	}
	
	private Cart getCart() {
		Cart cart=new Cart();
		List<Product> product=new ArrayList<Product>();
		product.add(null);
		cart.setProducts(product);
		return cart;
		
	}

}