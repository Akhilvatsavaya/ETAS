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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yantranet.etas.models.Cab;
import com.yantranet.etas.services.CabService;

@RestController
@RequestMapping("/cabs")
public class CabController 
{
	
	@Autowired
	private CabService cabService;
	
	// List all cabs
    @GetMapping
    public List<Cab> getAllCabs() 
    {
        return cabService.getAllCabs();
    }
    
    //Fetch a cab by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCabById(@PathVariable Long id)
    {
    	try
    	{
    		Optional<Cab> cab = cabService.getCabById(id);
    		if(cab.isPresent())
    		{
    			return ResponseEntity.ok(cab.get());
    		}
    		else
    		{
    			return ResponseEntity.badRequest().body("Cab not found");
    		}
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }
    
    //Add new Cab
    @PostMapping
    public ResponseEntity<?> addCab(@RequestBody Cab cab)
    {
    	try
    	{
    		Cab newCab = cabService.addCab(cab);
    		return ResponseEntity.ok(newCab);
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }
    
    //Update Details of a Cab
    @PutMapping
    public ResponseEntity<?> updateCab(@RequestBody Cab cab)
    {
    	try
    	{
    		Cab updatedCab = cabService.updateCab(cab);
    		return ResponseEntity.ok(updatedCab);
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }
    
    
    //Set Cab status to "AVAILABLE"
    @PutMapping("/{id}/available")
    public ResponseEntity<?> setCabAvailable(@PathVariable Long id)
    {
    	try
    	{
    		Cab updatedCab = cabService.setCabAvailable(id);
    		if(updatedCab != null)
    			return ResponseEntity.ok(updatedCab);
    		else
    			return ResponseEntity.badRequest().body("Cab Not Found");
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }
    
    //Set Cab status to "UNAVAILABLE"
    @PutMapping("/{id}/unavailable")
    public ResponseEntity<?> setCabUnavailable(@PathVariable Long id)
    {
    	try
    	{
    		Cab updatedCab = cabService.setCabUnavailable(id);
    		if(updatedCab != null)
    			return ResponseEntity.ok(updatedCab);
    		else
    			return ResponseEntity.badRequest().body("Cab Not Found");
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }
    
    //Remove a Cab
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCab(@PathVariable Long id)
    {
    	try
    	{
    		cabService.deleteCab(id);
    		return ResponseEntity.ok("Cab Deleted Successfully");
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }

}
