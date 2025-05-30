package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public class UserDTO {
    public enum Role { PASSENGER, OWNER, ADMIN }

    private Long user_id;

    @NotBlank
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be at most 100 characters")
    private String email;

    @Size(max = 15)
    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number must contain only digits and optional leading +")
    private String phoneNumber;

    @NotNull
    private Role role;

    private LocalDateTime registeredAt;

    private Long admin_id;

    private Long flightOwner_id;

    public UserDTO() {}

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
