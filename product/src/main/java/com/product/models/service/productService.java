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
		List<product> myList= ProductDao.findAll();
		
		for(product myProduct : myList) {
			if(myProduct.getExistentProduct()<=0) {
				myProduct.setIsbtnenabled(true);
			}
			else {
				myProduct.setIsbtnenabled(false);
			}
			myProduct.setTotal(myProduct.getListPrice()-myProduct.getDiscount()); 
			
		}
		return myList;
	}
	
	@Override
	public Integer maxId() {
		
		product myorder= ProductDao.findTopByOrderByIdDesc();
		int newId= myorder.getId()+1;
		return newId;
	}
	
}
