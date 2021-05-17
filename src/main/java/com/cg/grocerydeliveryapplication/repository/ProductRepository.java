package com.cg.grocerydeliveryapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.grocerydeliveryapplication.domain.Product;

import java.util.List;
public interface ProductRepository extends CrudRepository<Product,Integer>{

	Product findByProductId(int productId);

	
	Product findByCategoryName(String categoryName);


	List<Product> findProductByCategoryName(String categoryName);


	boolean deleteByProductId(int productId);

}