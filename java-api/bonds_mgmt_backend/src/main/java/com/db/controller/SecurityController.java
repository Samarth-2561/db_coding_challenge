package com.db.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.db.service.SecurityService;



@RestController
public class SecurityController {
	@PersistenceContext
	EntityManager em;

	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping(path = "/security")  
	private List<Security> getAllSecurity(){
	return securityService.getAllSecurity();  
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
	public MessageResponse getSecurityInformation(@RequestAttribute UserData user_data) {
		Query q = em.createNamedQuery("Security.innerJoinEverything"); 
		List<Security> bookUsers = q.getResultList();
		System.out.println(" "+bookUsers.size());
        for (Security i : bookUsers) {
 
            // Print all elements of ArrayList
            System.out.println(i.getId()+i.getIssuer()+i.getMaturity_Date()+i.getCoupon()+i.getFace_Value()+i.getStatus());
        }
        return new MessageResponse("Congratulations! These are books "+bookUsers.size());
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