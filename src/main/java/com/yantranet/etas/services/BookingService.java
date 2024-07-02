package com.yantranet.etas.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yantranet.etas.models.Booking;
import com.yantranet.etas.models.Cab;
import com.yantranet.etas.repositories.BookingRepository;
import com.yantranet.etas.repositories.CabRepository;
import com.yantranet.etas.repositories.EmployeeRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CabRepository cabRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//List all bookings
	public List<Booking> getAllBookings()
	{
		return bookingRepository.findAll();
	}
	
	//Fetch a booking by ID
	public Optional<Booking> getBookingById(Long id)
	{
		return bookingRepository.findById(id);
	}
	
//	//Add new Booking
//	public Booking addBooking(Booking booking)
//	{
//		return bookingRepository.save(booking);
//	}
	
	//Update an existing Booking
	public Booking updateBooking(Booking booking)
	{
		return bookingRepository.save(booking);
	}
	
	//Delete a booking by ID
	public void deleteBooking(Long id) throws ArithmeticException
	{
		Optional<Booking> booking = bookingRepository.findById(id);
		if(!booking.isPresent())
			throw new ArithmeticException("Booking Not Found");
		bookingRepository.deleteById(id);
	}
	
	//Request a Cab
	public Booking requestCab(String sourceLocation, LocalDateTime dateTimeOfJourney, Long employeeId) throws Exception
	{
		if(!isValidSource(sourceLocation))
			throw new Exception("SOURCE_INVALID");
		
		if(!isValidTime(dateTimeOfJourney))
			throw new Exception("INVALID_TRIP_TIME");
		
		if(!isRequestPossible(dateTimeOfJourney))
			throw new Exception("REQUEST_NOT_POSSIBLE");
		
		//Finding Available Cabs
		List<Cab> availableCabs = cabRepository.findByCabStatusAndVacancyGreaterThan("AVAILABLE", 0);
		if(availableCabs.isEmpty())
			throw new Exception("CAB_NOT_AVAILABLE");
		
		//Create a new Booking Request
		Booking booking = new Booking();
		booking.setRequestId(System.currentTimeMillis());
        booking.setSourceLocation(sourceLocation);
        booking.setDateTimeOfJourney(dateTimeOfJourney);
        booking.setRequestStatus("GENERATED");
        booking.setRequestCreationDate(LocalDateTime.now());
        booking.setRequestGenerator(employeeId);
        
        // Assign the first available cab
        Cab assignedCab = availableCabs.get(0);
        assignedCab.setVacancy(assignedCab.getVacancy() - 1);
        if (assignedCab.getVacancy() == 0) {
            assignedCab.setCabStatus("UNAVAILABLE");
        }
        cabRepository.save(assignedCab);
        
        booking.setVehicleDetails(assignedCab);
        booking.setPassengerDetails(employeeRepository.findById(employeeId).orElseThrow(() -> new Exception("EMPLOYEE_NOT_FOUND")));
        booking.setDriverDetails(employeeRepository.findById(assignedCab.getDriverId()).orElseThrow(() -> new Exception("DRIVER_NOT_FOUND")));
		
        Booking savedBooking = bookingRepository.save(booking);
        
        // Update request status to PROCESSED
        savedBooking.setRequestStatus("PROCESSED");
        booking.setBookingStatus("CONFIRMED");
        return bookingRepository.save(savedBooking);
	}
	
	// Check status of a booking request
    public Booking checkBookingStatus(Long requestId) throws Exception 
    {
        Optional<Booking> booking = bookingRepository.findByRequestId(requestId);
        if (!booking.isPresent()) 
        {
            throw new Exception("BOOKING_NOT_FOUND");
        }
        return booking.get();
    }
    
    // Validate source location
    private boolean isValidSource(String sourceLocation)
    {
        if(sourceLocation.equalsIgnoreCase("VISAKHAPATNAM")||sourceLocation.equalsIgnoreCase("NEW JERSEY"))
        	return true;
        return false;
    }
    
    // Check if the trip time is between 10pm-1am
    private boolean isValidTime(LocalDateTime dateTimeOfJourney)
    {
        int hours = dateTimeOfJourney.getHour();
        return hours >= 22 || hours < 1;
    }
    
    // Check if the request is made at least 12 hours in advance and not before 2 days
    private boolean isRequestPossible(LocalDateTime dateTimeOfJourney) 
    {
        LocalDateTime currentDate = LocalDateTime.now();
        long hoursDifference = java.time.Duration.between(currentDate, dateTimeOfJourney).toHours();
        return hoursDifference >= 12 && hoursDifference <= 48;
    }

}
