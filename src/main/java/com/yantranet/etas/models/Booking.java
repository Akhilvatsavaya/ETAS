package com.yantranet.etas.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue
	private Long bookingId;
	private Long requestId;
	private String sourceLocation;
	private LocalDateTime dateTimeOfJourney;
	private String requestStatus;
	private String bookingStatus;
	private LocalDateTime requestCreationDate;
	private Long requestGenerator;
	private String comments;
	
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee passengerDetails;
	
	@ManyToOne
	@JoinColumn(name = "cab_id")
	private Cab vehicleDetails;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Employee driverDetails;
	
	// Constructors

	public Booking()
	{
		
	}
	
	public Booking(Long bookingId, Long requestId, String sourceLocation, LocalDateTime dateTimeofJourney,
			String requestStatus, String bookingStatus, Employee passengerDetails, Cab vehicleDetails, 
			Employee driverDetails, LocalDateTime requestCreationDate, Long requestGenerator, String comments)
	{
		
		this.bookingId = bookingId;
		this.requestId = requestId;
		this.sourceLocation = sourceLocation;
		this.dateTimeOfJourney = dateTimeofJourney;
		this.requestStatus = requestStatus;
		this.bookingStatus = bookingStatus;
		this.passengerDetails = passengerDetails;
		this.vehicleDetails = vehicleDetails;
		this.driverDetails = driverDetails;
		this.requestCreationDate = requestCreationDate;
		this.requestGenerator = requestGenerator;
		this.comments = comments;
	}
	
	// Getters and Setters

	public Long getBookingId() {
		return bookingId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
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

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
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

	public LocalDateTime getRequestCreationDate() {
		return requestCreationDate;
	}

	public void setRequestCreationDate(LocalDateTime requestCreationDate) {
		this.requestCreationDate = requestCreationDate;
	}

	public Long getRequestGenerator() {
		return requestGenerator;
	}

	public void setRequestGenerator(Long requestGenerator) {
		this.requestGenerator = requestGenerator;
	}
	
	
	
	
	
	

}
