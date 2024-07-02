package com.yantranet.etas.dtos;

public class BookingResponse {
	
	private Long requestId;
	
	//Constructor
	public BookingResponse()
	{
		
	}
	public BookingResponse(Long requestId)
	{
		this.requestId = requestId;
	}
	
	//Getters and Setters
	public Long getRequestId()
	{
		return requestId;
	}
	
	public void setRequestId(Long requestId)
	{
		this.requestId = requestId;
	}

}
