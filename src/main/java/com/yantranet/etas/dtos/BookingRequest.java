package com.yantranet.etas.dtos;

import java.time.LocalDateTime;

public class BookingRequest {
	
	
	private String sourceLocation;
	private LocalDateTime dateTimeOfJourney;
	private Long employeeId;
	
	//Constructors
	public BookingRequest()
	{
		
	}
	
	public BookingRequest(String sourceLocation, LocalDateTime dateTimeOfJourney, Long employeeId)
	{
		this.sourceLocation = sourceLocation;
		this.dateTimeOfJourney = dateTimeOfJourney;
		this.employeeId = employeeId;
	}
	
	//Getters and Setters
	public String getSourceLocation() {
		return sourceLocation;
	}
	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
	public LocalDateTime getDateTimeOfJourney() {
		return dateTimeOfJourney;
	}
	public void setDateTimeOfJourney(LocalDateTime dateTimeOfJourney) {
		this.dateTimeOfJourney = dateTimeOfJourney;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
