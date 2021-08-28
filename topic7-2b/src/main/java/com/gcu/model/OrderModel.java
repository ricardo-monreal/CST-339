package com.gcu.model;

import org.springframework.data.annotation.Id;

public class OrderModel {
	
	
	@Id
	String id = "";
	String orderNo = "";
	String productName = "";
	float price = 0;
	int quantity = 0;
	
//	private String id;
//	private String orderNo;
//	private String productName;
//	private Float price;
//	//private Int quantity;
//	private Integer quantity;
	
	public OrderModel() {
		this.id = "";
		this.orderNo = "";
		this.productName = "";
		this.price = 0;
		this.quantity = 0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	public OrderModel(String id, String orderNo, String productName, Float price, Integer quantity) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	

}
