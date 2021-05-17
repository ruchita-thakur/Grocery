package com.cg.grocerydeliveryapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocerydeliveryapplication.domain.Payment;
import com.cg.grocerydeliveryapplication.exception.PaymentIdNotFoundException;
import com.cg.grocerydeliveryapplication.repository.PaymentRepository;

@Service
public class PaymentService {
	/**
	 * creating PaymentService class which give various services for payment class
	 */
	@Autowired
	private PaymentRepository paymentDao;
	/**
	 * creating savePayment method which saves the medical test details given 
	 * payment object
	 * 
	 * @param payment
	 * @return
	 */
	public Payment addPayment(Payment payment) {
		return paymentDao.save(payment);
	}
	/**
	 * creating findAll method which returns list of payments details from
	 * database
	 * 
	 * @return
	 * @throws PaymentIdNotFoundException 
	 */
	public List<Payment> findAll() throws PaymentIdNotFoundException{
		List<Payment> paymentList = paymentDao.findAll();
		if(paymentList.isEmpty()) {
			throw new PaymentIdNotFoundException("could not find payment");
		}
		return paymentList;
	}
	
	/**
	 * creating remove method which removes the details from the database given
	 * paymentId
	 * @param paymentId
	 * @return
	 * @throws PaymentIdNotFoundException 
	 */
	public boolean deletePayment(long paymentId) throws PaymentIdNotFoundException {
		Payment payment = paymentDao.findById(paymentId);
		if(payment == null) {
			throw new PaymentIdNotFoundException("payment with " + paymentId + " does not exist");
		}
		paymentDao.deleteById(paymentId);
		return true;
	}
	/**
	 * creating findById method to get the payment details based on Id
	 * 
	 * @param Id
	 * @return
	 */
	public Payment findById(long Id) {
		Payment payment = paymentDao.findById(Id);
		return payment;
	}

}