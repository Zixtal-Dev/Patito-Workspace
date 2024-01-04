package com.order.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="products")

public class product {		
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
		public String getNameproduc() {
			return nameproduct;
		}
		public void setNameproduc(String nameproduc) {
			this.nameproduct = nameproduc;
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
