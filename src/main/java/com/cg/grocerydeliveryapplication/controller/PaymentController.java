package com.cg.grocerydeliveryapplication.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocerydeliveryapplication.domain.Payment;
import com.cg.grocerydeliveryapplication.exception.PaymentIdNotFoundException;
import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;
import com.cg.grocerydeliveryapplication.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/payments")
@CrossOrigin("http://localhost:3000") 
public class PaymentController {
	/**
	 * autowiring paymentService to instantiate the object
	 */
	@Autowired
	private PaymentService paymentService;
	
	/**
	 * autowiring mapValidationErrorService to instantiate object
	 */
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	
	/**
	 * creating addPayment method to add the payment details into the database
	 * 
	 * @param payment
	 * @return
	 */
	
	
	@PostMapping("/insert")
	public ResponseEntity<?> addPayment(@Valid @RequestBody Payment payment, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap != null) {
			return errorMap; 
		}
		Payment newpayment = paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(newpayment, HttpStatus.OK);
	}
	
	/**
	 * creating viewPayment method to view all the payment details from database
	 * 
	 * @return
	 * @throws PaymentIdNotFoundException 
	 */
	
	@GetMapping("/all")
	public List<Payment> viewPayment() throws PaymentIdNotFoundException {
		return paymentService.findAll();
	}
	/**
	 *  creating removeById method to remove the payment details based on paymentId
	 *  
	 *  @param paymentId
	 *  @return
	 * @throws PaymentIdNotFoundException 
	 */
	
	@DeleteMapping("/delete/{paymentId}")
	public ResponseEntity<?> removeById(@PathVariable("paymentId") long paymentId) throws PaymentIdNotFoundException {
		boolean truth = paymentService.deletePayment(paymentId);
		return new ResponseEntity<String>("Payment with " + paymentId + "is deleted!", HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<?> findById(@PathVariable("paymentId") long paymentId) {
		Payment payment = paymentService.findById(paymentId);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}
	
}
