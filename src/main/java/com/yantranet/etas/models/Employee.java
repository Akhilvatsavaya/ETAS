package com.yantranet.etas.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String fullName;
	private String designation;
	private Date joiningDate;
	private String email;
	private String phone;
	private String address;
	
	//Constructors
	public Employee()
	{
		
	}
	
	public Employee(Long id, String fullName, String designation, Date joiningDate, 
			String email, String phone, String address)
	{
		this.id = id;
		this.fullName = fullName;
		this.designation = designation;
		this.joiningDate = joiningDate;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	//Getters and Setters
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	
	public String getDesignation()
	{
		return designation;
	}
	
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	
	public Date getJoiningDate()
	{
		return joiningDate;
	}
	
	public void setJoiningDate(Date joiningDate)
	{
		this.joiningDate = joiningDate;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	

}
