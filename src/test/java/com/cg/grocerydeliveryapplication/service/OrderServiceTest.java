package com.cg.grocerydeliveryapplication.service;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.grocerydeliveryapplication.domain.Order;
import com.cg.grocerydeliveryapplication.exception.OrderIdNotFoundException;
import com.cg.grocerydeliveryapplication.repository.OrderRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	@MockBean
	private OrderRepository orderRepository;

	@Test
	void deleteOrderTest() throws OrderIdNotFoundException {
		Order order=new Order();
		order.setOrderId(4);
		order.setUserName("sara");
		order.setOrderDate(null);
		order.setOrderStatus("Shipped");
		int orderId=order.getOrderId();
		Mockito.when(orderRepository.findByOrderId(orderId)).thenReturn(order);
			assertThat(orderServiceImpl.deleteOrder(orderId)).isEqualTo(true);      
        
			 
	}
	@Test
	void viewProductById() throws OrderIdNotFoundException {
		Order order=new Order();
		order.setOrderId(4);
		order.setUserName("mou");
		order.setOrderDate(null);
		order.setOrderStatus("Processing");
		int orderId=order.getOrderId();
		Mockito.when(orderRepository.findByOrderId(orderId)).thenReturn(order);
		assertThat(orderServiceImpl.viewOrderByOrderId(orderId)).isEqualTo(order);
		
	}
	@Test
	  void viewAllorders() { 
		  Order order1=new Order();
		
			 order1.setOrderId(1);
			 order1.setUserName("debo");
			 order1.setOrderDate(null);
			 order1.setOrderStatus("processing");
			  
			  Order order2=new Order();
			  order2.setOrderId(2);
			  order2.setUserName("leena");
			 order2.setOrderDate(null);
			 order2.setOrderStatus("shipped");
	  
	  List<Order> orderList=new ArrayList<Order>();
	  orderList.add(order1);
	  orderList.add(order2);
	  Mockito.when(orderRepository.findAll()).thenReturn(orderList);
	  assertEquals(orderServiceImpl.viewOrders(),orderList);
	   }}

