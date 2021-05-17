package com.cg.grocerydeliveryapplication.service;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.exception.ProductIdNotFoundException;
import com.cg.grocerydeliveryapplication.repository.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService productService;
	@MockBean
	private ProductRepository productRepository;
	@Test
	void addProduct() {
		Product product=new Product();
		product.setProductId(1);
		product.setProductName("apple");
		product.setCategoryName("fruits");
		product.setPrice(70);
		product.setQuantity(300);
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
        assertThat(productService.addProducts(product)).isEqualTo(product);
		
		}
	@Test
	void deleteProductTest() throws ProductIdNotFoundException {
		Product product=new Product();
		product.setProductId(4);
		product.setProductName("orange");
		product.setCategoryName("fruits");
		product.setPrice(56);
		product.setQuantity(534);
		int productId=product.getProductId();
		Mockito.when(productRepository.findByProductId(productId)).thenReturn(product);
			assertThat(productService.deleteProduct(productId)).isEqualTo(true);      
        
			 
	}
	@Test
	void viewProductById() throws ProductIdNotFoundException {
		Product product=new Product();
		product.setProductId(6);
		product.setProductName("onions");
		product.setCategoryName("vegetables");
		product.setPrice(39);
		product.setQuantity(634);
		int productId=product.getProductId();
		Mockito.when(productRepository.findByProductId(productId)).thenReturn(product);
		assertThat(productService.viewProductByProductId(productId)).isEqualTo(product);
		
	}
	@Test
	  void viewAllProducts() { 
		  Product product1=new Product();
	  product1.setProductId(2);
	  product1.setProductName("tomato");
	  product1.setCategoryName("vegetables");
		product1.setPrice(21);
	  product1.setQuantity(203);
	  
	  Product product2=new Product(); 
	  product2.setProductId(5);
	  product2.setProductName("beans");
	  product2.setCategoryName("vegetables");
		product2.setPrice(15);
	  product2.setQuantity(300);
	  
	  List<Product> productList=new ArrayList<Product>();
	  productList.add(product1);
	  productList.add(product2);
	  Mockito.when(productRepository.findAll()).thenReturn(productList);
	  assertEquals(productService.viewProducts(),productList);
	   }
	 @Test void updateProductTest() throws ProductIdNotFoundException {
		  Product product=new Product();
		  product.setProductId(2);
		  product.setProductName("watermelon");
		  product.setCategoryName("fruits");
			product.setPrice(79);
		  product.setQuantity(623);
		 Mockito.when(productRepository.findByProductId(2)).thenReturn(product);
		  product.setPrice(100);
		  product.setQuantity(956);
		  Mockito.when(productRepository.save(product)).thenReturn(product);
		  assertThat(productService.updateProduct(product,2)).isEqualTo(product);
		

	  }

}
