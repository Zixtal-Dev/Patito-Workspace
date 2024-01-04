package com.order.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.models.entity.client;


public interface clientDao extends JpaRepository<client, Long> {
	client findTopByOrderByIdDesc();
}
