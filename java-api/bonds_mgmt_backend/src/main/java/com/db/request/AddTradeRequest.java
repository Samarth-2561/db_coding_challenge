package com.db.request;

public class AddTradeRequest {
	public Long book_id;
	public Long counter_party_id;
	public Long security_id;
	public Long quantity;
	public String status;
	public Long price;
	public String trade_type;
	public String trade_date;
	public String settlement_date;
	
	public Long getBookId() {
		return book_id;
	}
	
	public Long getCounterPartyId() {
		return counter_party_id;
	}
	
	public Long getSecurityId() {
		return security_id;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public String getStatus() {
		return status;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public String getTradeType() {
		return trade_type;
	}
	
	public String getTradeDate() {
		return trade_date;
	}
	
	public String getSettlementDate() {
		return settlement_date;
	}
}
