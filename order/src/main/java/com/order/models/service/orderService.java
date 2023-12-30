package com.order.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.models.dao.orderDao;
import com.order.models.entity.order;

@Service
public class orderService implements IOrderService {
	
	@Autowired
	private orderDao OrderDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<order> findAll(){
		return (List<order>) OrderDao.findAll();
	} 
	
	@Override
	@Transactional
	public order save(order Order) {
		return OrderDao.save(Order);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		OrderDao.deleteById((long)id);
	}

	@Override
	public order findById(int id) {
		return OrderDao.findById((long)id).orElse(null);
	}

	@Override
	public order update(order Order) {
		return OrderDao.save(Order);
	}

	@Override
	public Integer maxId() {
		
		order myorder= OrderDao.findTopByOrderByIdDesc();
		return myorder.getId()+1;
	}


	


}