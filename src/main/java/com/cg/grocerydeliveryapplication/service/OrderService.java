package com.cg.grocerydeliveryapplication.service;

import com.cg.grocerydeliveryapplication.domain.Order;
import com.cg.grocerydeliveryapplication.exception.OrderIdNotFoundException;

public interface OrderService {
	public  Order addOrder(Order order);
	public boolean deleteOrder(int orderId);
	public Order viewOrderByOrderId(int orderId) throws OrderIdNotFoundException;
    public Iterable<Order> viewOrders();
	
}