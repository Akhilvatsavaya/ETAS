package com.yantranet.etas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yantranet.etas.dtos.BookingDetailsResponse;
import com.yantranet.etas.dtos.BookingRequest;
import com.yantranet.etas.dtos.BookingResponse;
import com.yantranet.etas.dtos.BookingStatusResponse;
import com.yantranet.etas.dtos.ErrorResponse;
import com.yantranet.etas.models.Booking;
import com.yantranet.etas.services.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	//Get all Bookings
	@GetMapping("/bookings")
	public List<Booking> getAllBookings()
	{
		return bookingService.getAllBookings();
	}
	
	//Fetch a Booking by Id
	@GetMapping("/bookings/{id}")
	public ResponseEntity<?> getBookingById(@PathVariable Long id)
	{
		try
		{
			Optional<Booking> booking = bookingService.getBookingById(id);
			if(booking.isPresent())
				return ResponseEntity.ok(booking.get());
			else
				return ResponseEntity.badRequest().body("Booking Not Found");
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
//	
//	//Add a new Booking
//	@PostMapping("/request")
//	public ResponseEntity<?> addBooking(@RequestBody Booking booking)
//	{
//		try
//		{
//			Booking newBooking = bookingService.addBooking(booking);
//			return ResponseEntity.ok(newBooking);
//		}
//		catch(Exception e)
//		{
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//	}
	
	//Update an Existing Booking
	@PutMapping("/bookings")
	public ResponseEntity<?> updateBooking(@RequestBody Booking booking)
	{
		try
		{
			Booking updatedBooking = bookingService.updateBooking(booking);
			return ResponseEntity.ok(updatedBooking);
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	//Delete a booking by Id
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable Long id)
	{
		try
		{
			bookingService.deleteBooking(id);
			return ResponseEntity.ok("Booking Deleted Successfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	// Requesting a Cab
	@PostMapping("/request")
	public ResponseEntity<?> requestCab(@RequestBody BookingRequest bookingRequest)
	{
		try
		{
			Booking booking = bookingService.requestCab(bookingRequest.getSourceLocation(), 
					bookingRequest.getDateTimeOfJourney(), bookingRequest.getEmployeeId());
			return ResponseEntity.ok(new BookingResponse(booking.getRequestId()));
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
		}
	}
	
	//Check the status of a Booking request
	@GetMapping("/request/{requestId}")
	public ResponseEntity<?> checkBookingStatus(@PathVariable Long requestId)
	{
		try
		{
			Booking booking = bookingService.checkBookingStatus(requestId);
			return ResponseEntity.ok(new BookingStatusResponse(booking.getRequestId(),
					booking.getRequestStatus(),
					booking.getComments(),
					booking.getBookingId(),
					booking.getSourceLocation(),
					booking.getDateTimeOfJourney(),
					booking.getRequestCreationDate(),
					booking.getRequestGenerator()));
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
		}
	}
	
	
	//Check the status of a booking
	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<?> checkBooking(@PathVariable Long bookingId)
	{
		try
		{
			Optional<Booking> booking = bookingService.getBookingById(bookingId);
			Booking newBooking = booking.get();
			if(booking.isPresent())
				return ResponseEntity.ok(new BookingDetailsResponse(newBooking.getBookingId(),
						newBooking.getSourceLocation(),
						newBooking.getDateTimeOfJourney(),
						newBooking.getBookingStatus(),
						newBooking.getPassengerDetails(),
						newBooking.getVehicleDetails(),
						newBooking.getDriverDetails()));
			else
				return ResponseEntity.badRequest().body("Booking Not Found");
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
		}
	}
}
