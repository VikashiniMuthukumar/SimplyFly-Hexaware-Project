package com.hexaware.simplyfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.simplyfly.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
