package com.cg.grocerydeliveryapplication.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
//import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocerydeliveryapplication.domain.Cart;
import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.service.CartService;

import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;



@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("api/v2/cart")
public class CartController {  
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
@Autowired
CartService cartService;

@PostMapping("/Carts")
public ResponseEntity<?> addFoodCart(@Valid @RequestBody Cart cart,BindingResult result){
	ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
	if(errorMap!=null) {
		return errorMap;
	}
	Cart newCart=cartService.addToCarts(cart);
	return new ResponseEntity<>(newCart,HttpStatus.CREATED);
	
}
@DeleteMapping("/{cartId}")
public ResponseEntity<String> deleteFoodCart(@PathVariable int cartId){
	cartService.deleteFromCart(cartId);
	
	return new ResponseEntity<>("Food item with Id : "+cartId+" id deleted.....", HttpStatus.OK);
	
}


@PutMapping("{cartId}")
public Cart updateCartById(@RequestBody Cart cart, @PathVariable("cartId") int cartId) {
	return cartService.updateCart(cart, cartId);
}

@GetMapping("/{cartId}")
public ResponseEntity<?> getCartById(@PathVariable ("cartId") int cartId)
{
	Cart cart=cartService.getCartById(cartId);
	Cart c1=new Cart();
	c1.setCartId(cart.getCartId());
	List<Product> product=cart.getProducts();
    for(Product p:product) {
    	p.setCart(null);
	c1.getProducts().add(p);
	
}
	//System.out.println(cart.toString());
	return new ResponseEntity(c1,HttpStatus.OK);
	
}
}
