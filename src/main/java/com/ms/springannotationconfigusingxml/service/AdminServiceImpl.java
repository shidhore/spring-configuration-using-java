package com.ms.springannotationconfigusingxml.service;

import java.util.List;

import com.ms.springannotationconfigusingxml.model.Admin;
import com.ms.springannotationconfigusingxml.repository.AdminRepository;

public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		System.out.println("---- AdminServiceImpl constructor invoked using CONSTRUCTOR injection ----");
		this.adminRepository = adminRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ms.springxmlconfig.service.AdminService#getAdmins()
	 */
	@Override
	public List<Admin> getAdmins() {
		return adminRepository.getAdmin();
	}

}
