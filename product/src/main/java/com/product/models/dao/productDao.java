package com.product.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.models.entity.product;

public interface productDao extends JpaRepository<product, Long> {

}
