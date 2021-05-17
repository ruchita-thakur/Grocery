package com.cg.grocerydeliveryapplication.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.grocerydeliveryapplication.domain.Payment;
import com.cg.grocerydeliveryapplication.exception.PaymentIdNotFoundException;
import com.cg.grocerydeliveryapplication.repository.PaymentRepository;
import com.cg.grocerydeliveryapplication.service.PaymentService;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
	
	
	/**
	 *creating a paymentDao object and instansiating it by using the @Mock 
	 *annotation 
	 */
	@Mock
	private PaymentRepository paymentDao;
	
	
	/**
	 * creating a paymentService object and instantiating it by using @InjectMocks
	 * annotation
	 */
	@InjectMocks
	private PaymentService paymentService;
	
	
	/**
	 * creating save test case to check whether the details are being saved and 
	 * returning the doctor object
	 */
	@Test
	void test1_addPayment() {
	Payment payment = new Payment("credit card", "1234123412341234", "shefali", "11/27", 123, 1,"99");
	BDDMockito.given(paymentDao.save(payment)).willReturn(payment);
	Payment a = paymentService.addPayment(payment);
	assertNotNull(a);
	assertEquals("credit card", a.getPaymentMode());
	assertEquals("1234123412341234", a.getCardNumber());
	}
	
	
	/**
	 * creating findAll test case to check whether the details are being fetched and 
	 * returning the list
	 * @throws PaymentIdNotFoundException 
	 */
	@Test
	public void test_FindAll_ReturnsListOfpayments() throws PaymentIdNotFoundException {
		List<Payment> list = new LinkedList<>();
		list.add(new Payment());
		list.add(new Payment());
		list.add(new Payment());
		when(paymentDao.findAll()).thenReturn(list);
		List result = paymentService.findAll();
		assertEquals(list.size(), result.size());
	}
	
	
	/**
	 * creating removePayment test case to check whether the details are being removed 
	 * from the database
	 * @throws PaymentIdNotFoundException 
	 */
	@Test
	public void test_RemovePayment_GivenPaymentId() throws PaymentIdNotFoundException {
		Payment newpayment = new Payment();
		Mockito.when(paymentDao.findById(1L)).thenReturn(newpayment).thenReturn(null);
		boolean result = paymentService.deletePayment(1);
		assertThat(result);
	}
	
	
	/**
	 * creating a findAll test case to check whether the exception is thrown when list is
	 * empty
	 */
	@Test
	public void test_FindAll_ThrowsExceptionIfListEmpty() {
		List<Payment> list = new ArrayList<>();
		assertThrows(PaymentIdNotFoundException.class, () -> paymentService.findAll());
	}
	
	
	/**
	 * creating remove test case to check whether exception is thrown when paymentId is not
	 * found
	 */
	@Test
	public void test_Remove_ThrowsException() {
		List<Payment> list = new ArrayList<>();
		list.add(new Payment());
		list.add(new Payment());
		list.add(new Payment());
		assertThrows(PaymentIdNotFoundException.class, () -> paymentService.deletePayment(1));
	}

}