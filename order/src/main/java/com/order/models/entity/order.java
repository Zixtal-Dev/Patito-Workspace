package com.order.models.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="orders")

public class order {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String seller;
private String clientname;
private String status;
private String idshop;

@Temporal(TemporalType.TIMESTAMP)
private Date createat;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSeller() {
	return seller;
}

public void setSeller(String seller) {
	this.seller = seller;
}

public String getClientname() {
	return clientname;
}

public void setClientname(String clientname) {
	this.clientname = clientname;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getIdShop() {
	return idshop;
}

public void setIdShop(String idShop) {
	this.idshop = idShop;
}

public Date getCreateAt() {
	return createat;
}

public void setCreateAt(Date createAt) {
	this.createat = createAt;
}




}

