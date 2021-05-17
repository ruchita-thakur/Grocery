package com.cg.grocerydeliveryapplication.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "OrderHistory")
public class Order {
	 @Override
		public String toString() {
			return "Order [OrderId=" + orderId + ", UserName=" + userName + ", OrderDate=" + orderDate +  ", OrderStatus=" + orderStatus + "]";
		}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int orderId;
	@NotBlank(message="order id should not be null")
	public String userName;
//	@NotBlank(message="user name should not be null")
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date orderDate;
	@NotNull(message="please enter order date")
   	public String orderStatus;
	
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public  Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderStatus(String orderStatus) {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
