package com.order.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.models.entity.pivot;

public interface pivotDao extends JpaRepository<pivot, Long> {
	List<pivot> findAllByOrderid(int id);
}
