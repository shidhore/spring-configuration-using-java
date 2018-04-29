package com.ms.springannotationconfigusingxml.service;

import java.util.List;

import com.ms.springannotationconfigusingxml.model.User;
import com.ms.springannotationconfigusingxml.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.springxmlconfig.service.UserService#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		return userRepository.getUser();
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		System.out.println("---- setUserRepository method invoked using SETTER injection ----");
		this.userRepository = userRepository;
	}

}
