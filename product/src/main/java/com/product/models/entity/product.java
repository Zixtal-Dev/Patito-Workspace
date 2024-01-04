package com.product.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")

public class product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameproduct;
	private int existentproduct;
	private float listprice;
	private float discount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameProduc() {
		return nameproduct;
	}
	public void setNameProduc(String nameProduc) {
		this.nameproduct = nameProduc;
	}
	public int getExistentProduct() {
		return existentproduct;
	}
	public void setExistentProduct(int existentProduct) {
		this.existentproduct = existentProduct;
	}
	public float getListPrice() {
		return listprice;
	}
	public void setListPrice(float listPrice) {
		this.listprice = listPrice;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	private static final long serialVersionUID=6893004409787670260L;
	
	
}
