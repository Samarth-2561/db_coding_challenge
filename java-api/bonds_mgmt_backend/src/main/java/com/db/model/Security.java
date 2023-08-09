package com.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Table(name="Security")
//mark class as an Entity   
@Entity
@NamedNativeQueries({

    @NamedNativeQuery(
        name = "Security.innerJoinEverything",
        query =
            "SELECT security.id, issuer, maturity_date, coupon, security.type, face_value ,security.status FROM security inner join trade on security.id = trade.security_id inner join bookusers on trade.book_id = bookusers.book_id inner join users on users.id = bookusers.user_id;", resultClass = Security.class
    )
})
//defining class name as Table name  

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
@Column(name="Issuer") 
private String Issuer;  
//defining age as column name  
@Column(name="Maturity_Date")  
private Date Maturity_Date;  
//defining email as column name  
@Column(name="Coupon")  
private int Coupon; 

@Column(name="Type")  
private String Type; 

@Column(name="Face_Value")  
private int Face_Value;

@Column(name="Status")
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

