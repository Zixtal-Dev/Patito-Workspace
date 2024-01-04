package com.product.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.models.dao.productDao;
import com.product.models.entity.product;


@Service
public class productService implements IProductService {

	@Autowired
	private productDao ProductDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<product> findAll(){
		return (List<product>) ProductDao.findAll();
	}
	
	@Override
	public Integer maxId() {
		
		product myorder= ProductDao.findTopByOrderByIdDesc();
		int newId= myorder.getId()+1;
		return newId;
	}
	
}
