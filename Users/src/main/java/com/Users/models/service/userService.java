package com.Users.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Users.models.dao.userDao;
import com.Users.models.entity.user;

@Service
public class userService implements IUserService {
	
	@Autowired
	private userDao UserDao;
	
	@Override
	@Transactional
	
	public user save(user User) {
		return UserDao.save(User);
	}

}
