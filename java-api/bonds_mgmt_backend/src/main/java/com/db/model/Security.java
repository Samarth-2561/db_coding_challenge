package com.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(
	    name = "Security.addSecurity",
	    query =
	        "INSERT INTO security (issuer, maturity_date, coupon, type, face_value, status) VALUES (?, ?, ?, ?, ?, ?);", 
	    resultClass = Security.class
	)
})
public class Security   
{  
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  Long  id;  
  
	private String issuer;  
  
	private Date maturity_date;  
  
	private int coupon; 
	
	private String type; 
	
	private int face_value;
	
	private String status;
	
	
	public String getIssuer() {
		return issuer;
	}
}  

