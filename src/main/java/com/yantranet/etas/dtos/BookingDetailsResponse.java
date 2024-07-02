package com.yantranet.etas.dtos;

import java.time.LocalDateTime;

import com.yantranet.etas.models.Cab;
import com.yantranet.etas.models.Employee;

public class BookingDetailsResponse {
	
	private Long bookingId;
	private String sourceLocation;
	private LocalDateTime dateTimeOfJourney;
	private String bookingStatus;
	private Employee passengerDetails;
	private Cab vehicleDetails;
	private Employee driverDetails;
	
	//Constructors
	
	public BookingDetailsResponse()
	{
		
	}
	
	
	public BookingDetailsResponse(Long bookingId, String sourceLocation, LocalDateTime dateTimeOfJourney,
			String bookingStatus, Employee passengerDetails, Cab vehicleDetails, Employee driverDetails) {
		super();
		this.bookingId = bookingId;
		this.sourceLocation = sourceLocation;
		this.dateTimeOfJourney = dateTimeOfJourney;
		this.bookingStatus = bookingStatus;
		this.passengerDetails = passengerDetails;
		this.vehicleDetails = vehicleDetails;
		this.driverDetails = driverDetails;
	}

	
	//Getters and Setters
	public Long getBookingId() {
		return bookingId;
	}


	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}


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


	public String getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public Employee getPassengerDetails() {
		return passengerDetails;
	}


	public void setPassengerDetails(Employee passengerDetails) {
		this.passengerDetails = passengerDetails;
	}


	public Cab getVehicleDetails() {
		return vehicleDetails;
	}


	public void setVehicleDetails(Cab vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}


	public Employee getDriverDetails() {
		return driverDetails;
	}


	public void setDriverDetails(Employee driverDetails) {
		this.driverDetails = driverDetails;
	}

}
