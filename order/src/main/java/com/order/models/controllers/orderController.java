package com.order.models.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.order.models.entity.order;
import com.order.models.entity.pivot;
import com.order.models.entity.product;
import com.order.models.entity.productInOrder;
import com.order.models.service.IOrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class orderController {

		@Autowired
		private IOrderService OrderService;
		
		@GetMapping("/order/list")
		public List<order> list(){
			return (List<order>) OrderService.findAll();
		}
		
		@GetMapping("/order/maxid")
		public Integer max() {
			return OrderService.maxId();
		}
		
		@GetMapping("/order/show/{id}")
		public order show(@PathVariable("id") int id) {
			return OrderService.findById(id);
		}
		
		@GetMapping("/product/show/{id}")
		public product productshow(@PathVariable("id") int id) {
			return OrderService.findProById(id);
		}
		
		@GetMapping("/order/pivot/{id}")
		public List<productInOrder> findpivot(@PathVariable("id") int id) {
			return OrderService.findProdutc(id);
		}
		

		
		@PostMapping("/order/create")
		@ResponseStatus(HttpStatus.CREATED)
		public order create(@RequestBody order Order) {
			return OrderService.save(Order);
		}
		
		@PutMapping("/order/update/{id}")
		public order update(@PathVariable("id") int id,@RequestBody order Order ) {
			Order.setId(id);
			return OrderService.update(Order);
		}
		
		@DeleteMapping("/order/delete/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable("id") int id) {
			OrderService.delete(id);
		}
		
		@DeleteMapping("/order/pivot/delete/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletePivot(@PathVariable("id") int id) {
			OrderService.deletePivot(id);
		}
		
		@PostMapping("/pivote/create/{orderid}/{productid}")
		@ResponseStatus(HttpStatus.CREATED)
		public pivot createPivote(@RequestBody pivot Pivot,@PathVariable("orderid") int orderid,@PathVariable("productid") int productid) {
			return OrderService.savePivot(Pivot, orderid, productid);
		}
		
		@GetMapping("/order/total/{id}")
		public float total(@PathVariable("id") int id) {
			return OrderService.Total(id);
		}
		@GetMapping("/date/{id}")
		public Boolean FindDate(@PathVariable("id") int id) {
			return OrderService.getDifferenceBetwenDates(id);
		}

}
