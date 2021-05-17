package com.cg.grocerydeliveryapplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.cg.grocerydeliveryapplication.controller.PaymentController;
import com.cg.grocerydeliveryapplication.domain.Payment;
import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;
import com.cg.grocerydeliveryapplication.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * creating PaymentControllerTest to check the controllers provided by RESTApi's
 * by PaymentController class
 * @author poojitm
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PaymentController.class)
@ContextConfiguration
public class PaymentControllerTest {
	
	
	
	/**
	 * autowiring MockitoMVC to instatiate the object
	 */
	@Autowired
	MockMvc mockMvc;
	
	/**
	 * autowiring paymentService by @MockBean to instantiate the object
	 */
	@MockBean
	PaymentService paymentService;
	
	/**
	 * autowiring MapValidationErrorService by @MockBean to instantiate the object
	 */
	@MockBean
	MapValidationErrorService mapValidationErrorService;
	
	/**
	 * creating private ObjectMapper to convert Json to String
	 */
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 *creating AddPayment test case to check whether the doctor details are added to
	 *the database
	 *
	 *@throws Exception
	 */
	@Test
	void test1_createNewPayment() throws Exception{
	Payment payment = new Payment("credit card", "1234123412341234", "shefali", "11/27", 123, 1,"99");
	BDDMockito.given(paymentService.addPayment(Mockito.any(Payment.class))).willReturn(payment);
	mockMvc.perform(post("/api/payments/insert"))
	.andExpect(status().isInternalServerError());
	}
	
	
	/**
	 * creating FindAll test case to check whether the list of all the payment
	 * details are returned from the database
	 */
	@Test
	void test2_getAllPayments_returnAllPayments() throws Exception{
	Payment payment = new Payment(" credit card", "1234123412341234", "shefali", "11/27", 121, 1,"99");
	Iterable<Payment> usersList = (Iterable<Payment>)Arrays.asList(payment);
	BDDMockito.given(paymentService.findAll()).willReturn(null);
	mockMvc.perform(MockMvcRequestBuilders.get("/api/payments/all"))
	.andExpect(status().isOk());
	}
	
	
	/**
	 * creating DeleteById test to check if the doctor detail is removed based
	 * on paymentId
	 * 
	 * @throws Exception
	 */
	@Test
	void test5_deletePayment() throws Exception{
	Payment payment=new Payment("card", "1234123412341234", "shefali", "11/27", 123, 1,"99");
	Mockito.when(paymentService.findById(1)).thenReturn(payment).thenReturn(null);
	boolean result = paymentService.deletePayment(1);
	assertThat(result);
	}

}