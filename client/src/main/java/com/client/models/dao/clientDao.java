package com.client.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.client.models.entity.client;

public interface clientDao extends JpaRepository<client, Long> {

}
