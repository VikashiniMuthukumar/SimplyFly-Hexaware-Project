package com.hexaware.simplyfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Admin;
import com.hexaware.simplyfly.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	AdminRepository repo;
	
	@Override
	public Admin getAdminById(Long adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin assignAdminRole(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
