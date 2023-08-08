
package com.db.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.model.Security;
import com.db.repository.SecurityRepository;



@Service
public class SecurityService {
	
 
	@Autowired  
	SecurityRepository securityRepository;  
	//getting all student records  
	public List<Security> getAllSecurity()   
	{  
	List<Security> securities = new ArrayList<Security>();  
	securityRepository.findAll().forEach(securities::add);  
	return securities;  
	}  
	//getting a specific record  
	public Security getSecurityById(long id)   
	{  
	return securityRepository.findById(id).get();  
	} 
	
	public void saveOrUpdate(Security securityModel)   
	{  
	securityRepository.save(securityModel);  
	}  
	//deleting a specific record  
	public void delete(long id)   
	{  
	securityRepository.deleteById(id);  
	}  
	 
	}  