package com.cg.grocerydeliveryapplication.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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





@Entity
public class Cart {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId; 
	
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER,targetEntity=Product.class ,cascade=CascadeType.ALL)
	
	private List<Product> products=new ArrayList<Product>();
//	@NotBlank(message="Name should not be null.")
//	private String productName;	
//	@NotBlank(message="There will be always some quantity.")	
//	private String productQuantity;		
//	@NotNull(message="There won't be a food item will zero price. ")
//	private int productPrice;
//	@NotNull(message="quantity should not zero")
//    @Max(1000)
//	private int quantity;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Cart(int cartId, List<Product> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}
	public Cart() {
		
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + ", getCartId()=" + getCartId() + ", getProducts()="
				+ getProducts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	

}
