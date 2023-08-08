package com.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Security;
import com.db.service.SecurityService;



@RestController
public class SecurityController {
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping(path = "/security")  
	private List<Security> getAllSecurity(){
	return securityService.getAllSecurity();  
	}  
	
	@GetMapping(path = "/security/{id}")  
	private Security getSecurity(@PathVariable("id") int id)   
	{  
	return securityService.getSecurityById(id);  
	}  
	
	@DeleteMapping("/security/{id}")  
	private void deleteSecurity(@PathVariable("id") int id)   
	{  
		securityService.delete(id);  
	}  
	@PostMapping("/security")  
	private long saveSecurity(@RequestBody Security securityModel)   
	{  
		securityService.saveOrUpdate(securityModel);  
	return securityModel.getId();
	}  

}