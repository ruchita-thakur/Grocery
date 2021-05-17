package com.cg.grocerydeliveryapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	  @MockBean
	  private ProductService productService;
	  
	 
 @Test
void  testAddProduct() throws Exception {
	
	  Product product= new Product(); 
	  String uri="/api/v2/Products";
	  product.setProductId(1);
	  product.setProductName("onions");
	  product.setCategoryName("vegetables");
	  product.setPrice(30);
	  product.setQuantity(900);
	  product.setDescription("freshly produced");
	  String jsonInput=this.converttoJson(product);
	  Mockito.when(productService.addProducts(Mockito.any(Product.class))).thenReturn(product);
	  System.out.println(product.getCategoryName());
	  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
	                            .accept(MediaType.APPLICATION_JSON)
	                            .content(jsonInput)
	                            .contentType(MediaType.APPLICATION_JSON))
			                    .andReturn();
	  
		
//	  MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//	    String jsonOutput = mockHttpServletResponse.getContentAsString();
//	    assertThat(jsonInput).isEqualTo(jsonOutput);
		  Assert.assertEquals(HttpStatus.CREATED.value(),mvcResult.getResponse().getStatus());
	 
	}
 @Test
	void testDeleteProduct() throws Exception {
		Product product= new Product(); 
		  String uri="/api/v2//{productId}";
		  product.setProductId(2);
		  product.setProductName("tomato");
		  product.setCategoryName("vegetables");
		  product.setPrice(22000);
		  product.setQuantity(309);
		  int productId=product.getProductId();
		  String jsonInput=this.converttoJson(product);
			
			  Mockito.when(productService.viewProductByProductId(productId)).thenReturn( product);
			  Mockito.when(productService.deleteProduct(productId)).thenReturn(true);
			 
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(uri,2)
		                            .accept(MediaType.APPLICATION_JSON)
		                            .content(jsonInput)
		                            .contentType(MediaType.APPLICATION_JSON))
				                    .andReturn();
		 
		  Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		  
}
 @Test
 void testViewAllProduct() throws Exception {
	 
	 String uri="/api/v2/all";
	 Product product1=new Product();
	 product1.setProductId(1);
	  product1.setProductName("apples");
	  product1.setCategoryName("fruits");
	  product1.setPrice(150);
	  product1.setQuantity(300);
	  
	  Product product2=new Product();
	  product2.setProductId(2);
	  product2.setProductName("oranges");
	  product2.setCategoryName("fruits");
	  product2.setPrice(80);
	  product2.setQuantity(679);
	  
	  List<Product> productList=new ArrayList<Product>();
	  productList.add(product1);
	  productList.add(product2);		  
	  String jsonInput=this.converttoJson(productList);
	  Mockito.when(productService.viewProducts()).thenReturn(productList);
	  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
              .accept(MediaType.APPLICATION_JSON)
              .content(jsonInput)
              .contentType(MediaType.APPLICATION_JSON))
              .andReturn();
            
    Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
	  
 }

 @Test
 void testViewProductById() throws Exception {
	 String uri="/api/v2/{productId}" ;
	 Product product=new Product();		 
	  product.setProductId(2);
	  product.setProductName("watermelon");
	  product.setCategoryName("fruits");
	  product.setPrice(90);
	  product.setQuantity(500);
	  String jsonInput=this.converttoJson(product);
	  
	  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,2)
              .accept(MediaType.APPLICATION_JSON)
              .content(jsonInput)
              .contentType(MediaType.APPLICATION_JSON))
              .andReturn();
	 
	  Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
			 
 }
 @Test
 void testUpdateProduct() throws Exception {
	 String uri= "/api/v2/{productId}";
	 Product product=new Product();		 
	  product.setProductId(5);
	  product.setProductName("beans");
	  product.setCategoryName("vegetables");
	  product.setPrice(25);
	  product.setQuantity(309);
	  String jsonInput=this.converttoJson(product);
	  Mockito.when(productService.updateProduct(product, 5)).thenReturn(product);
	  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(uri,5)
              .accept(MediaType.APPLICATION_JSON)
              .content(jsonInput)
              .contentType(MediaType.APPLICATION_JSON))
              .andReturn();
	  Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	  		 
 }
 private String converttoJson(Object product) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
     return objectMapper.writeValueAsString(product);
	}
}
