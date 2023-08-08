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
            "SELECT * FROM trade inner join bookusers on trade.book_id = bookusers.book_id inner join users on "
            + "users.id = bookusers.user_id inner join security on security.id = trade.security_id inner join books "
            + "on books.id = trade.book_id;", resultClass = Trade.class
    ),
    
    @NamedNativeQuery(
            name = "Trade.getTradeByUserID",
            query =
                "SELECT * FROM trade inner join bookusers on trade.book_id = bookusers.book_id inner join users on "
                + "users.id = bookusers.user_id AND users.id = ? inner join security on security.id = trade.security_id inner join books "
                + "on books.id = trade.book_id;", resultClass = Trade.class
    ),
    
    @NamedNativeQuery(
            name = "Trade.getTradeByID",
            query =
                "SELECT * FROM trade where id = ?;", resultClass = Trade.class
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CounterParty getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(CounterParty counterParty) {
		this.counterParty = counterParty;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public Date getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}

	public Date getSettlement_date() {
		return settlement_date;
	}

	public void setSettlement_date(Date settlement_date) {
		this.settlement_date = settlement_date;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

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
