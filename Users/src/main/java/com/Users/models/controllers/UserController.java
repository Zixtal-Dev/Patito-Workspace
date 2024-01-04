package com.Users.models.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Users.models.entity.user;
import com.Users.models.service.IUserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private IUserService UserService;
	
	@PostMapping("/user/create")
	public user create(@RequestBody user User) {
		return UserService.save(User);
	}
}
