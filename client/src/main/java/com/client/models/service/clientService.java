package com.client.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.models.dao.clientDao;
import com.client.models.entity.client;

import org.springframework.transaction.annotation.Transactional;

@Service
public class clientService implements IClientService {
	
	@Autowired
	private clientDao ClientDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<client> findAll(){
		return (List<client>) ClientDao.findAll();
	}
	
	@Override
	@Transactional
	public client save(client Cliente) {
		return ClientDao.save(Cliente);
	}
	
}