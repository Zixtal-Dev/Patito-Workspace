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
	@Transactional
	public void deletePivot(int id) {
		PivotDao.deleteByOrderid(id);
	}

	@Override
	@Transactional(readOnly=true)
	public order findById(int id) {
		return OrderDao.findById((long)id).orElse(null);
	}

	@Override
	public order update(order Order) {
		return OrderDao.save(Order);
	}

	@Override
	@Transactional(readOnly=true)
	public Integer maxId() {
		
		order myorder= OrderDao.findTopByOrderByIdDesc();
		return myorder.getId()+1;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<productInOrder> findProdutc(int id) {
		List<pivot> myPivotList= PivotDao.findAllByOrderid(id);
		List<productInOrder> listnewOrderProduct = new ArrayList<productInOrder>();
		for(pivot myPivot: myPivotList) 
		{
			productInOrder newOrderProduct = new productInOrder();
			product newProduct= findProById(myPivot.getProductid());
			newOrderProduct.setAmount(myPivot.getAmount());
			newOrderProduct.setDiscount(newProduct.getDiscount());
			newOrderProduct.setExistentproduct(newProduct.getExistentProduct());
			newOrderProduct.setListprice(newProduct.getListPrice());
			newOrderProduct.setNameproduc(newProduct.getNameProduct());
			newOrderProduct.setOrderid(myPivot.getOrderid());
			newOrderProduct.setProductid(myPivot.getProductid());
			newOrderProduct.setTotal((newProduct.getListPrice()-newProduct.getDiscount())*myPivot.getAmount());
			
			listnewOrderProduct.add(newOrderProduct);
		}
		return listnewOrderProduct;
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

	@Override
	public pivot savePivot(pivot Pivot,int orderid,int productid) {
		List<pivot> findorder = PivotDao.findAllByOrderid(orderid);
		if(findorder.size()>0) {
			pivot newPivot = new pivot();
			Boolean isProduct=false; 
			for(pivot MyfindOrder: findorder) 
			{
				if(MyfindOrder.getProductid()== productid) 
				{
					MyfindOrder.setAmount(MyfindOrder.getAmount()+1);
					newPivot=MyfindOrder;
					isProduct=true;
					break;
				}
				
			}
			
			if(isProduct) {
				return PivotDao.save(newPivot);
			}
			
			else {
				return PivotDao.save(Pivot);
			}
						
		}
		else{
			return PivotDao.save(Pivot);
		}
	}

	@Override
	public product findProById(int id) { 
		return ProductDao.findById((long)id).orElse(null);
	}

}
