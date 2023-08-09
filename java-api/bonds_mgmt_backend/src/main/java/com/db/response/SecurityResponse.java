package com.db.response;

import java.util.List;

import com.db.model.Security;
import com.db.model.Trade;

public class SecurityResponse {

	private List<Security> data;
	
	public List<Security> getData() {
		return data;
	}

	public void setData(List<Security> data) {
		this.data = data;
	}

	public SecurityResponse(List<Security> data) {
		this.data = data;
	}
	
}
