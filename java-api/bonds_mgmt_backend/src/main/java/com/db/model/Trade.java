/**
 * 
 */
package com.db.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedNativeQueries({

    @NamedNativeQuery(
        name = "Trade.innerJoinEverything",
        query =
            "SELECT * FROM trade inner join bookusers on trade.book_id = bookusers.book_id inner join users on users.id = bookusers.user_id inner join security on security.id = trade.security_id inner join books on books.id = trade.book_id;", resultClass = Trade.class
    ),
    @NamedNativeQuery(
        name = "Trade.addTrade",
        query =
            "INSERT INTO trade (book_id, counter_party_id, security_id, quantity, status, price, trade_type, trade_date, settlement_date) \n"
            + "VALUES (?,?,?,?,?,?,?,?,?);", resultClass = Trade.class
    )
})
public class Trade {
	

	private @Id @GeneratedValue Long id;
	@OneToOne
    private Books book;
	@OneToOne
    private CounterParty counterParty;
	@OneToOne
    private Security security;
	@OneToOne
	@JoinColumn(name= "user_id")
    private User user;
	
	private int quantity;
	
	private String status;
	
	private int price;
	
	private String trade_type;
	
	private Date trade_date;  
	 
	private Date settlement_date;  


	@Override
	public String toString() {
		return counterParty.getCounterPartyName() + " " + quantity + " " + status + " " + price + " " + trade_type + " " + trade_date + " " + settlement_date;	 	
	}
	
	public Books getBook() {
		return book;
	}
	
	public User getUser() {
		return user;
	}
	
	public Security getSecurity() {
		return security;
	}
	
	
	
}
