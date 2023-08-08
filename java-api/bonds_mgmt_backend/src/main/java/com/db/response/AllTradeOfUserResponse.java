/**
 * 
 */
package com.db.response;

import java.util.Date;
import java.util.List;

import com.db.model.Trade;

/**
 * 
 */
public class AllTradeOfUserResponse {

	private List<Trade> data;
	
	public List<Trade> getData() {
		return data;
	}

	public void setData(List<Trade> data) {
		this.data = data;
	}

	public AllTradeOfUserResponse(List<Trade> data) {
		this.data = data;
	}
}
