package com.db.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Security;
import com.db.model.Trade;
import com.db.model.UserData;
import com.db.response.MessageResponse;
import com.db.response.SecurityResponse;
import com.db.service.SecurityService;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api")
public class SecurityController {
	@PersistenceContext
	EntityManager em;

	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping(path = "/security")  
	private ResponseEntity<?> getAllSecurity(@RequestAttribute UserData user_data){
		Query q = em.createNamedQuery("Security.innerJoinEverything"); 
		q.setParameter(1, user_data.getId());
		List<Security> security_data = q.getResultList();
		return ResponseEntity.ok(new SecurityResponse(security_data));
	}  
	
//	@GetMapping(path="/securityforUserId/{id}")
//	private List<Security> getSecuritiesWithDetails(@PathVariable("id") int id){
//		return securityService.getSecuritiesWithDetails(id);
//	}
	
	@GetMapping(path = "/security/{id}")  
	private Security getSecurity(@PathVariable("id") int id)   
	{  
	return securityService.getSecurityById(id);  
	} 
	
	@GetMapping("/getAllSecurityInformation")
	public List<Security> getSecurityInformation() {
		return securityService.getAllSecurity();  
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