package com.product.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.models.entity.product;
import com.product.models.service.IProductService;

@RestController
@CrossOrigin("*")
public class productController {

	
	@Autowired
	private IProductService ProductService;
	
	@GetMapping("/product/list")
	public List<product> list(){
		return ProductService.findAll();
	}
}
