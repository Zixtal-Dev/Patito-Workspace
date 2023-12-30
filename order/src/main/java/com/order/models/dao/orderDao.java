package com.order.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.order.models.entity.order;

public interface orderDao extends JpaRepository<order, Long> {
    order  findTopByOrderByIdDesc();

}
