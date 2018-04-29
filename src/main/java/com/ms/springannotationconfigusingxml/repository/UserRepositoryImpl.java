package com.ms.springannotationconfigusingxml.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ms.springannotationconfigusingxml.model.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Value("${usernameInPropertiesFile}")
	private String usernameInJavaClass;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.springxmlconfig.repository.UserRepository#getUser()
	 */
	@Override
	public List<User> getUser() {
		System.out.println("user name in properties file = " + usernameInJavaClass);
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setUserName("MS");
		users.add(user);
		return users;
	}

}
