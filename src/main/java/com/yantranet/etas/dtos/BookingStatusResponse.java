package com.yantranet.etas.dtos;

import java.time.LocalDateTime;

public class BookingStatusResponse {
	
	private Long requestId;
	private String requestStatus;
	private String comments;
	private Long bookingId;
	private String sourceLocation;
	private LocalDateTime dateTimeOfJourney;
	private LocalDateTime requestCreationDate;
	private Long requestGenerator;
	
	//Constructors
	public BookingStatusResponse()
	{
		
	}
	
	public BookingStatusResponse(Long requestId, String requestStatus, String comments, 
			Long bookingId, String sourceLocation, LocalDateTime dateTimeOfJourney, 
			LocalDateTime requestCreationDate, Long requestGenerator)
	{
		this.requestId = requestId;
		this.requestStatus = requestStatus;
		this.comments = comments;
		this.bookingId = bookingId;
		this.sourceLocation = sourceLocation;
		this.dateTimeOfJourney = dateTimeOfJourney;
		this.requestCreationDate = requestCreationDate;
		this.requestGenerator = requestGenerator;
	}
	
	//Getters and Setters

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

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
