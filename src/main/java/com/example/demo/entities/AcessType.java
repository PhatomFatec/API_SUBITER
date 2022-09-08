package com.example.demo.entities;

public enum AcessType {

	ADMIN(1), 
	SUPPORT(2), 
	CLIENT(3);
	
	private int code;
	
	private AcessType(int code) {
		this.code = code;
		
	}
	
	public int getCode() {
		return code;
	}
	
	public static AcessType valueOf(int code) {
		for(AcessType values : AcessType.values()) {
			if (values.getCode() == code) {
				return values;
			}
		}
		throw new IllegalArgumentException("Invalid AcessType Code");
		
	}

}
