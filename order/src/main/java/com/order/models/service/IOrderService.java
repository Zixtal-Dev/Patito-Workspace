package com.order.models.service;

import java.util.List;

import com.order.models.entity.order;

public interface IOrderService {
	
	public List<order> findAll();
	public order findById(int id);
	
	public order save(order Order);
	public order update(order Order);
	
	public void delete(int id);
	
	public Integer maxId(); 
}