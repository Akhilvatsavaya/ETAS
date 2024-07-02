package com.yantranet.etas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cabs")
public class Cab {
	
	@Id
	@GeneratedValue
	private Long cabId;
	private String registrationNumber;
	private Long driverId;
	private String cabStatus;
	private String comments;
	private int vacancy;
	
	// Constructors
	
	public Cab()
	{
		
	}
	
	public Cab(Long cabId, String registrationNumber, Long driverId, String cabStatus, 
			String comments, int vacancy)
	{
		this.cabId = cabId;
		this.registrationNumber = registrationNumber;
		this.driverId = driverId;
		this.cabStatus = cabStatus;
		this.comments = comments;
		this.vacancy = vacancy;
	}
	

	// Getters and Setters

	public Long getCabId() {
		return cabId;
	}

	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getCabStatus() {
		return cabStatus;
	}

	public void setCabStatus(String cabStatus) {
		this.cabStatus = cabStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	
	
	
	
	
	
	
	
}
