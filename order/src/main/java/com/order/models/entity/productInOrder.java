package com.order.models.entity;

public class productInOrder {
	int orderid;
	int productid;
	int amount;
	private String nameproduc;
	private int existentproduct;
	private float listprice;
	private float discount;
	private float Total;
	
	public int getOrderid() {
		return orderid;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNameproduc() {
		return nameproduc;
	}
	public void setNameproduc(String nameproduc) {
		this.nameproduc = nameproduc;
	}
	public int getExistentproduct() {
		return existentproduct;
	}
	public void setExistentproduct(int existentproduct) {
		this.existentproduct = existentproduct;
	}
	public float getListprice() {
		return listprice;
	}
	public void setListprice(float listprice) {
		this.listprice = listprice;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
}