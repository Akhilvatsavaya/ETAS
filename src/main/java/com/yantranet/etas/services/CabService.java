package com.yantranet.etas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yantranet.etas.models.Cab;
import com.yantranet.etas.models.Employee;
import com.yantranet.etas.repositories.CabRepository;
import com.yantranet.etas.repositories.EmployeeRepository;

@Service
public class CabService {
	
	@Autowired
	private CabRepository cabRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	// List all Cabs
	public List<Cab> getAllCabs()
	{
		return cabRepository.findAll();
	}
	
	//Fetch a cab by ID
	public Optional<Cab> getCabById(Long id)
	{
		return cabRepository.findById(id);
	}
	
	//Add a cab
	public Cab addCab(Cab cab)
	{
		Optional<Employee> addEmployee = employeeRepository.findById(cab.getDriverId());
		if(addEmployee.isEmpty())
			throw new RuntimeException("Driver Not Found");
		if(!addEmployee.get().getDesignation().equalsIgnoreCase("driver"))
			throw new RuntimeException("Employee is Not Driver");
		if(cab.getCabId() == null)
			return cabRepository.save(cab);
		Optional<Cab> addCab = cabRepository.findById(cab.getCabId());
		if(!addCab.isPresent())
			return cabRepository.save(cab);
		else
			throw new RuntimeException("Cab not Added!! ID cannot be the same.");
	}
	
	//Update details of a Cab
	public Cab updateCab(Cab cab)
	{
		Optional<Cab> updateCab = cabRepository.findById(cab.getCabId());
		if(updateCab.isPresent())
			return cabRepository.save(cab);
		else
			throw new RuntimeException("Cab Not Found!! Check Cab ID");
	}
	
	//Set cab status to 'AVAILABLE'
	public Cab setCabAvailable(Long Id)
	{
		Optional<Cab> optionalCab = cabRepository.findById(Id);
		if(optionalCab.isPresent())
		{
			Cab cab = optionalCab.get();
			if(cab.getVacancy() >= 4)
				throw new RuntimeException("Vacancy Cannot be greater than 4");
			cab.setCabStatus("AVAILABLE");
			cab.setVacancy(cab.getVacancy() + 1);
			return cabRepository.save(cab);
		}
		
		return null;
	}
	
	//Set cab status to 'UNAVAILABLE'
	public Cab setCabUnavailable(Long id)
	{
		Optional<Cab> optionalCab = cabRepository.findById(id);
		if(optionalCab.isPresent())
		{
			Cab cab = optionalCab.get();
			cab.setCabStatus("UNAVAILABLE");
			cab.setVacancy(0);
			return cabRepository.save(cab);
		}
		return null;
	}
	
	//Remove a Cab
	public void deleteCab(Long id)
	{
		Optional<Cab> deleteCab = cabRepository.findById(id);
		if(deleteCab.isPresent())
			cabRepository.deleteById(id);
		else
			throw new RuntimeException("Cab Not Found!!");
	}

}
