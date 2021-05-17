package com.cg.grocerydeliveryapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocerydeliveryapplication.domain.Order;
import com.cg.grocerydeliveryapplication.exception.OrderIdNotFoundException;
import com.cg.grocerydeliveryapplication.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public   Order addOrder(Order order) {
		return orderRepository.save(order);

	}

	@Override
	public boolean deleteOrder(int orderId) {
		//Order order=orderRepository.findByOrderId(orderId);		
		 orderRepository.deleteById(orderId);
		return true;
	}

	@Override
	public Order viewOrderByOrderId(int orderId) throws OrderIdNotFoundException {
		
		Order order= orderRepository.findByOrderId(orderId);
		if(order!=null) {
			
			return order;
			}
			else {
				throw new OrderIdNotFoundException("Order with id "+orderId+" is not present.");
			}
	}

	@Override
	public Iterable<Order> viewOrders() {
		
		return orderRepository.findAll();
	}

	
}
