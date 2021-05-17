package com.cg.grocerydeliveryapplication.controller;

import javax.validation.Valid;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.exception.ProductIdNotFoundException;
import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;
import com.cg.grocerydeliveryapplication.service.ProductService;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/v2")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private MapValidationErrorService mapValidation;
	@PostMapping("Products")
	public ResponseEntity<?> addProducts(@Valid @RequestBody Product product,BindingResult result){
		ResponseEntity<?> errorMap=mapValidation.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Product newProduct=productService.addProducts(product);
		return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		
	}
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId){
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product with Id : "+productId+" id deleted.....", HttpStatus.OK);
		
	}
	@PutMapping("{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product ,@PathVariable int productId) throws ProductIdNotFoundException{
		Product updatedProduct=productService.updateProduct(product, productId);
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		
	}
	@GetMapping("all")
	public Iterable<Product> viewProducts(){
		
		return productService.viewProducts();
	}
	@GetMapping("{productId}")
	public ResponseEntity<Product> viewProductByProductId(@PathVariable int productId) throws ProductIdNotFoundException{		
		
		return new ResponseEntity<>(productService.viewProductByProductId(productId),HttpStatus.OK);
		
	}
	@GetMapping
	@RequestMapping("/category/{categoryName}")
	public ResponseEntity<List<Product>> viewProductByCategoryName(@PathVariable String categoryName){
		return new ResponseEntity<List<Product>>(productService.viewProductByCategoryName(categoryName),HttpStatus.OK);
		
	}

	
	

}