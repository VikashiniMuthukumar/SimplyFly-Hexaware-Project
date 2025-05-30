package com.hexaware.simplyfly.dto;

import java.util.List;

public class FlightDTO {
    
    private Long flight_id;
    private String name;
    private String flightCode;
    private int totalSeats;
    private int cabinBaggageLimit;
    private int checkInBaggageLimit;

    private Long owner_id;  // Refers to FlightOwner

    private List<Long> route_ids; // List of Route IDs assigned to this flight

    public FlightDTO() {
       super();
    }

    public FlightDTO(Long flight_id, String name, String flightCode, int totalSeats,
                     int cabinBaggageLimit, int checkInBaggageLimit,
                     Long owner_id, List<Long> route_ids) {
        this.flight_id = flight_id;
        this.name = name;
        this.flightCode = flightCode;
        this.totalSeats = totalSeats;
        this.cabinBaggageLimit = cabinBaggageLimit;
        this.checkInBaggageLimit = checkInBaggageLimit;
        this.owner_id = owner_id;
        this.route_ids = route_ids;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getCabinBaggageLimit() {
        return cabinBaggageLimit;
    }

    public void setCabinBaggageLimit(int cabinBaggageLimit) {
        this.cabinBaggageLimit = cabinBaggageLimit;
    }

    public int getCheckInBaggageLimit() {
        return checkInBaggageLimit;
    }

    public void setCheckInBaggageLimit(int checkInBaggageLimit) {
        this.checkInBaggageLimit = checkInBaggageLimit;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public List<Long> getRoute_ids() {
        return route_ids;
    }

    public void setRoute_ids(List<Long> route_ids) {
        this.route_ids = route_ids;
    }
}
