package com.cg.grocerydeliveryapplication.service;


import java.io.IOException;
import java.util.List;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.exception.ProductIdNotFoundException;
import com.cg.grocerydeliveryapplication.repository.ProductRepository;
@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProducts(Product product ){
		//String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		
		return productRepository.save(product);
		
	}

	@Override
	public boolean deleteProduct(int productId) {
		//Product product=productRepository.findByProductId(productId);		
		 productRepository.deleteById(productId);;
		return true;
	}

	@Override
	public Product updateProduct(Product product,int productId) throws ProductIdNotFoundException {
		Product reqProduct=productRepository.findByProductId(productId);
		if(reqProduct!=null) {
			reqProduct.setPrice(product.getPrice());
			reqProduct.setQuantity(product.getQuantity());
			 return productRepository.save(reqProduct);		 
			  
		  }
		  else {
				throw new ProductIdNotFoundException("Unable to get the product details. ");
			}
		  
	}

	@Override
	public Product viewProductByProductId(int productId) throws ProductIdNotFoundException {
		
		Product product= productRepository.findByProductId(productId);
		if(product!=null) {
			
			return product;
			}
			else {
				throw new ProductIdNotFoundException("Product with id "+productId+" is not present.");
			}
	}

	@Override
	public Iterable<Product> viewProducts() {
		
		return productRepository.findAll();
	}

	
	@Override
	public List<Product> viewProductByCategoryName(String categoryName) {
		List<Product> product=productRepository.findProductByCategoryName(categoryName);
		return product;
	}

	

	
}