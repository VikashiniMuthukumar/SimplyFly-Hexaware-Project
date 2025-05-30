package com.hexaware.simplyfly.dto;

import java.util.List;

public class FlightOwnerDTO {
    
    private Long owner_id;       // Same as user_id
    private Long user_id;        // Associated user
    private List<Long> flight_ids; // List of Flight IDs owned by this user

    public FlightOwnerDTO() {
        super();
    }

    public FlightOwnerDTO(Long owner_id, Long user_id, List<Long> flight_ids) {
        this.owner_id = owner_id;
        this.user_id = user_id;
        this.flight_ids = flight_ids;
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

    public List<Long> getFlight_ids() {
        return flight_ids;
    }

    public void setFlight_ids(List<Long> flight_ids) {
        this.flight_ids = flight_ids;
    }
}
