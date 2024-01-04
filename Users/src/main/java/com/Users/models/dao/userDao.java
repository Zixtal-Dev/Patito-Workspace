package com.Users.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Users.models.entity.user;

public interface userDao extends JpaRepository<user, Long> {

}
