package com.db.request;

public class AddSecurityRequest {
	public String issuer;
	public Long coupon;
	public String type;
	public Long faceValue;
	public String maturityDate;
	
	public String getIssuer() {
		return issuer;
	}

	public String getMaurityDate() {
		return maturityDate;
	}
	
	public Long getCoupon() {
		return coupon;
	}
	
	public Long getFaceValue() {
		return faceValue;
	}
	
	public String getStatus() {
		return "not-mature";
	}
	
	public String getType() {
		return type;
	}
	
}
