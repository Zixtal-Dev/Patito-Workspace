package com.client.models.service;

import java.util.List;

import com.client.models.entity.client;

public interface IClientService {
	
	public List<client> findAll();
	
	public client save(client Client);
}
