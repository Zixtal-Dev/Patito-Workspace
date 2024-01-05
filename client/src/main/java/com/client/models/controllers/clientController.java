package com.client.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.models.entity.client;
import com.client.models.service.IClientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class clientController {
	
	@Autowired
	private IClientService ClientService;
	
	@GetMapping("/client/list")
	public List<client> list(){
		return (List<client>) ClientService.findAll();
	}
	
	@PostMapping("/client/create")
	public client create(@RequestBody client Client) {
		return ClientService.save(Client);
	}
	
	@GetMapping("/client/maxid")
	public Integer max() {
		return ClientService.maxId();
	}
	
	@GetMapping("/client/show/{id}")
	public client findClient(@PathVariable("id") int id) {
		return ClientService.finById(id);
	}
}
