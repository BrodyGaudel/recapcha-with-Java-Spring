package com.brody.recaptcha.service;

import java.util.List;

import com.brody.recaptcha.entity.User;

public interface UserService {
	
	Integer createUser(User user);
	List<User> getAllUsers();

}
