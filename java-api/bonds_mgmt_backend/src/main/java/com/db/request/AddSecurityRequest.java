package com.db.request;

public class AddSecurityRequest {
	private String issuer;
	private Long coupon;
	private String type;
	private Long faceValue;
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
