package com.db.response;

import java.util.Date;

public class TradeResponse {
	
	private int price;
	private int quantity;

	private Date settlement_date;
	private String status;
	private Date trade_date;
	private String type_type;
	private String bookName;
	private String countPartyName;
	private String securityName;
	
	public TradeResponse(int price, int quantity, Date settlement_date, String status, Date trade_date,
			String type_type, String bookName, String countPartyName, String securityName) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.settlement_date = settlement_date;
		this.status = status;
		this.trade_date = trade_date;
		this.type_type = type_type;
		this.bookName = bookName;
		this.countPartyName = countPartyName;
		this.securityName = securityName;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Date getSettlement_date() {
		return settlement_date;
	}


	public void setSettlement_date(Date settlement_date) {
		this.settlement_date = settlement_date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getTrade_date() {
		return trade_date;
	}


	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}


	public String getType_type() {
		return type_type;
	}


	public void setType_type(String type_type) {
		this.type_type = type_type;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getCountPartyName() {
		return countPartyName;
	}


	public void setCountPartyName(String countPartyName) {
		this.countPartyName = countPartyName;
	}


	public String getSecurityName() {
		return securityName;
	}


	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}


	public void setPrice(int price) {
		this.price = price;
	}
}
