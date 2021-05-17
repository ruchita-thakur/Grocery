package com.cg.grocerydeliveryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.grocerydeliveryapplication.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart findByCartId(int cartId);
}