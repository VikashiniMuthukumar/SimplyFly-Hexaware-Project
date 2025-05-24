package com.hexaware.simplyfly.dto;

public class FlightOwnerDTO {

	private Long owner_id;
    private Long user_id;
	public FlightOwnerDTO(Long owner_id, Long user_id) {
		super();
		this.owner_id = owner_id;
		this.user_id = user_id;
	}
	public Long getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
    
}
