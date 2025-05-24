package com.hexaware.simplyfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.simplyfly.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
