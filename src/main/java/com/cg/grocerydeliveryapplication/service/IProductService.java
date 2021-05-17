package com.cg.grocerydeliveryapplication.service;


import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import com.cg.grocerydeliveryapplication.domain.Product;
import com.cg.grocerydeliveryapplication.exception.ProductIdNotFoundException;

public interface IProductService {
	public Product addProducts(Product product);
	public boolean deleteProduct(int productId);
	public Product updateProduct(Product product, int productId) throws ProductIdNotFoundException;
	public Product viewProductByProductId(int productId) throws ProductIdNotFoundException;
    public Iterable<Product> viewProducts();
   
    public List<Product> viewProductByCategoryName(String categoryName);
	//public Product addProducts(Product product, MultipartFile file);
	
}