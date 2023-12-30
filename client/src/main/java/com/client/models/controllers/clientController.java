package com.client.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.models.entity.client;
import com.client.models.service.IClientService;

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
}
