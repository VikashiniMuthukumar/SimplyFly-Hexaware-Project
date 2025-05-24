package com.hexaware.simplyfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.simplyfly.entities.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long>{

}
