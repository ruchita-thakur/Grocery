package com.cg.grocerydeliveryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.grocerydeliveryapplication.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	public Payment findById(long paymentId);
}
