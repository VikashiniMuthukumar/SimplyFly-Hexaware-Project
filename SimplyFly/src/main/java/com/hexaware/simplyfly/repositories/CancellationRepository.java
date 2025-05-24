package com.hexaware.simplyfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.simplyfly.entities.Cancellation;

@Repository
public interface CancellationRepository extends JpaRepository<Cancellation, Long>{

}
