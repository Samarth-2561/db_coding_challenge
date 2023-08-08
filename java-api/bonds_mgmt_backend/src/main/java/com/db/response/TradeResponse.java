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
	private String userName;
	private String email;
	
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
	
	public TradeResponse(int price, int quantity, Date settlement_date, String status, Date trade_date,
			String type_type, String bookName, String countPartyName, String securityName, String userName,
			String email) {
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
		this.userName = userName;
		this.email = email;
	}
	
	
}
