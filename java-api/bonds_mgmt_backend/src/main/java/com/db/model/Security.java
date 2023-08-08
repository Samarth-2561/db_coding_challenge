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
@Table(name = "security")
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

// public enum STATUS{
    // not_mature(0), mature(1), post_mature(2);

    // private int value;
    // STATUS(int v/alue){this.value=value;}
    // public int getValue(){return value;}

//mark id as primary key   

//@Column(name="Indexes")
//private int Indexes;
//defining id as column name 
@Id
@Column(name="id") 
private long  id;  
//defining name as column name  
@Column(name="issuer") 
private String Issuer;  
//defining age as column name  
@Column(name="maturity_date")  
private Date Maturity_Date;  
//defining email as column name  
@Column(name="coupon")  
private int Coupon; 

@Column(name="type")  
private String Type; 

@Column(name="face_value")  
private int Face_Value;

@Column(name="status")
private String Status;



public long getId()   
{  
return id;  
}  
public void setId(long id)   
{  
this.id = id;  
}  
public String getIssuer()   
{  
return Issuer;  
}  
public void setIssuer(String name)   
{  
this.Issuer = name;  
}  
public Date getMaturity_Date()   
{  
return Maturity_Date;  
}  
public int getCoupon()   
{  
return Coupon;  
}  
public void setCoupon(int coupon)   
{  
this.Coupon = coupon;  
}  

public String getType()   
{  
return Type;  
}  
public void setType(String type)   
{  
this.Type = type;  
}  
public int getFace_Value()   
{  
return Face_Value;  
}  
public void setFace_Value(int value)   
{  
this.Face_Value = value;  
}  



public String getStatus()   
{  
    return Status;  
}  
public void setStatus(String value)   
{  
    this.Status = value;  
}  

}  

