package com.yantranet.etas.dtos;

public class ErrorResponse {
	
	private String errorCode;
	
	// Constructor
	public ErrorResponse(String errorCode)
	{
		this.errorCode = errorCode;
	}
	
	//Getters and Setters
	public String getErrorCode()
	{
		return errorCode;
	}
	
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

}
