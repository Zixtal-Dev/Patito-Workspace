package com.order.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.models.entity.product;

public interface productDao extends JpaRepository<product, Long> {

}
