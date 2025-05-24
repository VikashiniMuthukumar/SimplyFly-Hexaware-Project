package com.hexaware.simplyfly.dto;

public class FlightDTO {
	private Long flight_id;
    private String name;
    private String flightCode;
    private int totalSeats;
    private int cabinBaggageLimit;
    private int checkInBaggageLimit;
    
    
	public FlightDTO(Long flight_id, String name, String flightCode, int totalSeats, int cabinBaggageLimit,
			int checkInBaggageLimit) {
		super();
		this.flight_id = flight_id;
		this.name = name;
		this.flightCode = flightCode;
		this.totalSeats = totalSeats;
		this.cabinBaggageLimit = cabinBaggageLimit;
		this.checkInBaggageLimit = checkInBaggageLimit;
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
	
    
    
}
