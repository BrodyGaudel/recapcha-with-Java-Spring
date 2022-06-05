package com.brody.recaptcha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brody.recaptcha.entity.User;
import com.brody.recaptcha.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	@Override
	public Integer createUser(User user) {
		
		return userRepository.save(user).getId();
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

}
