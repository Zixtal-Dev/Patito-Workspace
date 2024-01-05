package com.order.models.service;

import java.util.Date;
import java.util.List;

import com.order.models.entity.order;
import com.order.models.entity.pivot;
import com.order.models.entity.product;
import com.order.models.entity.productInOrder;

public interface IOrderService {
	
	public List<order> findAll();
	public order findById(int id);
	
	public order save(order Order);
	public order update(order Order);
	
	public void delete(int id);
	
	public Integer maxId(); 
	
	public List<productInOrder> findProdutc(int id);
	
	public float Total(int id);
	
	public product findProById(int id); 
		
	public pivot savePivot(pivot Pivot,int orderid,int productid);
	
	public void deletePivot(int id);
	
	public  Boolean getDifferenceBetwenDates(int orderid);
	}
