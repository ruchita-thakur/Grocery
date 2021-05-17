package com.cg.grocerydeliveryapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.cg.grocerydeliveryapplication.domain.Order;
import com.cg.grocerydeliveryapplication.exception.OrderIdNotFoundException;
import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;
import com.cg.grocerydeliveryapplication.service.OrderServiceImpl;

@RestController

@RequestMapping("/orderHistory")
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	@Autowired
	private MapValidationErrorService mapValidation;
	@PostMapping("addOrders")
	public ResponseEntity<?> addOrder(@Valid @RequestBody Order order,BindingResult result){
		ResponseEntity<?> errorMap=mapValidation.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Order newOrder=orderServiceImpl.addOrder(order);
		return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
		
	}
	@DeleteMapping("{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable int orderId){
		orderServiceImpl.deleteOrder(orderId);
		return new ResponseEntity<>("Order with Id : "+orderId+" id deleted.....", HttpStatus.OK);
		
	}
	@GetMapping("all")
	public Iterable<Order> viewOrders(){
		
		return orderServiceImpl.viewOrders();
	}
	@GetMapping("{orderId}")
	public ResponseEntity<Order> viewOrderByOrderId(@PathVariable int orderId) throws OrderIdNotFoundException{		
		
		return new ResponseEntity<>(orderServiceImpl.viewOrderByOrderId(orderId),HttpStatus.OK);
		
	}

	
	

}
