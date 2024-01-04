package com.order.models.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.models.dao.clientDao;
import com.order.models.dao.orderDao;
import com.order.models.dao.pivotDao;
import com.order.models.dao.productDao;
import com.order.models.entity.client;
import com.order.models.entity.order;
import com.order.models.entity.pivot;
import com.order.models.entity.product;
import com.order.models.entity.productInOrder;

@Service
public class orderService implements IOrderService {
	
	@Autowired
	private orderDao OrderDao;
	@Autowired
	private pivotDao PivotDao;
	@Autowired
	private productDao ProductDao;
	@Autowired
	private clientDao ClientDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<order> findAll(){
		List<order> mylist = OrderDao.findAll();
		for(order myorder : mylist) 
		{
		 client myclient = ClientDao.findById((long)myorder.getClientid()).orElse(null);
		 myorder.setClientname(myclient.getClientname());
		}
		return mylist;
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
		return myorder.getId();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<productInOrder> findProdutc(int id) {
		List<pivot> myPivotList= PivotDao.findAllByOrderid(id);
		List<productInOrder> myProductInOrderList = new ArrayList<productInOrder>();
		float total=0;
		for(pivot myPivot : myPivotList) {
			productInOrder myProductInOrder=new productInOrder();
			product myProduct = ProductDao.findById((long)myPivot.getOrderid()).orElse(null);
			
			myProductInOrder.setAmount(myPivot.getAmount());
			myProductInOrder.setDiscount(myProduct.getDiscount());
			myProductInOrder.setExistentproduct(myProduct.getExistentproduct());
			myProductInOrder.setListprice(myProduct.getListprice());
			myProductInOrder.setNameproduc(myProduct.getNameproduc());
			myProductInOrder.setOrderid(myPivot.getOrderid());
			myProductInOrder.setProductid(myPivot.getProductid());
			myProductInOrder.setTotal((myProduct.getListprice()-myProduct.getDiscount())*myPivot.getAmount());
			total=total+myProductInOrder.getTotal();
			myProductInOrderList.add(myProductInOrder);
		}
		return myProductInOrderList;
	}
	
	@Override
	@Transactional(readOnly=true)
	public float Total(int id) {
		float total=0;
		List<productInOrder> myList = findProdutc(id);
		for(productInOrder myProduct : myList) {
			total=total + myProduct.getTotal();
		}
		return total;
	}
	
	public static Date getDifferenceBetwenDates(Date dateInicio) {
		
		Date currentDate =  new Date();
		
	    long milliseconds = currentDate.getTime() - dateInicio.getTime();
	    int seconds = (int) (milliseconds / 1000) % 60;
	    int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
	    int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.SECOND, seconds);
	    c.set(Calendar.MINUTE, minutes);
	    c.set(Calendar.HOUR_OF_DAY, hours);
	    return c.getTime();
	}
	


	


}
