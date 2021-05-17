package com.cg.grocerydeliveryapplication.domain;

/**
 * Product domain class
 */

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * 
 * @author Chaturya Challa
 *
 */


@Entity
public class Product {

	//attributes of product
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	@NotBlank(message="product name should not be null")
	@Size(min=5, max=20)
	private String productName;
	@NotBlank(message="category name should not be null")
	@Size(min=5, max=15)
	private String categoryName;
	@NotNull(message="quantity should not zero")
    @Max(1000)
	private int quantity;
	@NotNull(message="price should not zero")
   	private double price;
	@NotBlank(message="description should not be null")
	private String description;
	private String Image;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	//getters and setters
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	//Constructor
	public Product() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public  String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", categoryName=" + categoryName
				+ ", quantity=" + quantity + ", price=" + price + ", description=" + description + ", Image=" + Image
				+ ", cart=" + cart + ", getImage()=" + getImage() + ", getProductId()=" + getProductId()
				+ ", getProductName()=" + getProductName() + ", getCategoryName()=" + getCategoryName()
				+ ", getQuantity()=" + getQuantity() + ", getPrice()=" + getPrice() + ", getDescription()="
				+ getDescription() + ", getCart()=" + getCart() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Product(int productId,
			@NotBlank(message = "product name should not be null") @Size(min = 5, max = 20) String productName,
			@NotBlank(message = "category name should not be null") @Size(min = 5, max = 15) String categoryName,
			@NotNull(message = "quantity should not zero") @Max(1000) int quantity,
			@NotNull(message = "price should not zero") double price,
			@NotBlank(message = "description should not be null") String description, String image, Cart cart) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryName = categoryName;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		Image = image;
		this.cart = cart;
	}
	
	
}
