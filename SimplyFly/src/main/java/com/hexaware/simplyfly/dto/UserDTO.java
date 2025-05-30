package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;

public class UserDTO {
    
    public enum Role { PASSENGER, OWNER, ADMIN }

    private Long user_id;
    private String name;
    private String email;
    private String phoneNumber;
    private Role role;
    private LocalDateTime registeredAt;

    private Long admin_id;         // Optional - reference to Admin
    private Long flightOwner_id;   // Optional - reference to FlightOwner

    public UserDTO() {
        // Default constructor
    }

    public UserDTO(Long user_id, String name, String email, String phoneNumber,
                   Role role, LocalDateTime registeredAt,
                   Long admin_id, Long flightOwner_id) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.registeredAt = registeredAt;
        this.admin_id = admin_id;
        this.flightOwner_id = flightOwner_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public Long getFlightOwner_id() {
        return flightOwner_id;
    }

    public void setFlightOwner_id(Long flightOwner_id) {
        this.flightOwner_id = flightOwner_id;
    }
}
