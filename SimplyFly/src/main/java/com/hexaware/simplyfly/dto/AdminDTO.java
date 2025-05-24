package com.hexaware.simplyfly.dto;

import com.hexaware.simplyfly.entities.User;

public class AdminDTO {
	private Long id;
    private User user;
    
    public AdminDTO() {
    	super();
    }
    
	public AdminDTO(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
