package com.ms.springannotationconfigusingxml.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ms.springannotationconfigusingxml.model.Guest;

// if @Repository annotation is removed or commented out, it will throw the following exception 
// org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.ms.springxmlconfig.repository.GuestRepository' available: 
// expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
@Repository
public class GuestRepositoryImpl implements GuestRepository {
	
	@Value("${passwordInPropertiesFile}")
	private String passwordInJavaClass;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.springxmlconfig.repository.GuestRepository#getGuests()
	 */
	@Override
	public List<Guest> getGuests() {
		System.out.println("password in properties file = " + passwordInJavaClass);
		List<Guest> guests = new ArrayList<>();
		Guest guest = new Guest();
		guest.setUserName("Guest");
		guests.add(guest);
		return guests;
	}

}
