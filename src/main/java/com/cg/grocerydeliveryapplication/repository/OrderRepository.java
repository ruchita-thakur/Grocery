package com.cg.grocerydeliveryapplication.repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.grocerydeliveryapplication.domain.Order;

public interface OrderRepository extends CrudRepository<Order,Integer>{

	Order findByOrderId(int orderId);

}

