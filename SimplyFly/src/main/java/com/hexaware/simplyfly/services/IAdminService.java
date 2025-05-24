package com.hexaware.simplyfly.services;

import com.hexaware.simplyfly.entities.Admin;

public interface IAdminService{

	Admin getAdminById(Long adminId);
    Admin assignAdminRole(Long userId);
}
