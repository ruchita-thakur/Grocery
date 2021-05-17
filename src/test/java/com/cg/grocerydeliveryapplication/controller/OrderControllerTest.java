package com.cg.grocerydeliveryapplication.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MvcResult;


import com.cg.grocerydeliveryapplication.domain.Order;
import com.cg.grocerydeliveryapplication.service.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	  @MockBean
	  private OrderServiceImpl orderServiceImpl;
	  
	 

 /*@Test
	void testDeleteOrder() throws Exception {
		Order order= new Order(); 
		  String uri="/{orderId}";
		  order.setOrderId(2);
		  order.setUserName("lina");
		 // Date date= new Date(2021-01-11);
		  order.setOrderDate(null);
		  order.setOrderStatus("shipped");
		  int orderId=order.getOrderId();
		  String jsonInput=this.converttoJson(order);
			
			  Mockito.when(orderServiceImpl.viewOrderByOrderId(orderId)).thenReturn( order);
			  Mockito.when(orderServiceImpl.deleteOrder(orderId)).thenReturn(true);
			 
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(uri,2)
		                            .accept(MediaType.APPLICATION_JSON)
		                            .content(jsonInput)
		                            .contentType(MediaType.APPLICATION_JSON))
				                    .andReturn();
		 
		  Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		  
}
*/
@Test
 void testViewAllOrder() throws Exception {
	 
	 String uri="/orderHistory/all";
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
	  String jsonInput=this.converttoJson(orderList);
	  Mockito.when(orderServiceImpl.viewOrders()).thenReturn(orderList);
	  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
              .accept(MediaType.APPLICATION_JSON)
              .content(jsonInput)
              .contentType(MediaType.APPLICATION_JSON))
              .andReturn();
            
    Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
	  
 }


@Test
 void testViewOrderById() throws Exception {
	 String uri="/orderHistory/{orderId}" ;
	 Order order=new Order();		 
	  order.setOrderId(2);
	  order.setUserName("bubun");
	  order.setOrderDate(null);
	  order.setOrderStatus("processing");
	  String jsonInput=this.converttoJson(order);
	  
	  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,2)
              .accept(MediaType.APPLICATION_JSON)
              .content(jsonInput)
              .contentType(MediaType.APPLICATION_JSON))
              .andReturn();
	 
	  Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
			 
 }
private String converttoJson(Object order) throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();
 return objectMapper.writeValueAsString(order);
}
}
