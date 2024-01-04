package com.order.models.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="orders")

public class order {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String seller;
private Integer clientid;

@Transient
private String clientname;

private String status;
private String idshop;

@Temporal(TemporalType.TIMESTAMP)
private Date createat;

public Integer getId() {
	return id;
}

public String getClientname() {
	return clientname;
}

public void setClientname(String clientname) {
	this.clientname = clientname;
}

public void setId(Integer id) {
	this.id = id;
}

public String getSeller() {
	return seller;
}

public void setSeller(String seller) {
	this.seller = seller;
}

public Integer getClientid() {
	return clientid;
}

public void setClientid(Integer clientid) {
	this.clientid = clientid;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getIdshop() {
	return idshop;
}

public void setIdshop(String idshop) {
	this.idshop = idshop;
}

public Date getCreateat() {
	return createat;
}

public void setCreateat(Date createat) {
	this.createat = createat;
}





}


