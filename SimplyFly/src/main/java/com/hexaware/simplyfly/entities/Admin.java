package com.hexaware.simplyfly.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {
    @Id
    @Column(name = "admin_id")
    private Long admin_id;

    @OneToOne
    @JoinColumn(name = "admin_id")
    @MapsId
    private User user;

	public Admin() {
		super();
	}

	public Admin(Long admin_id, User user) {
		super();
		this.admin_id = admin_id;
		this.user = user;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}    
	
	
}
