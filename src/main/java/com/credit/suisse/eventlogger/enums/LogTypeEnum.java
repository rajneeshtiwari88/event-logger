package com.credit.suisse.eventlogger.enums;

public enum LogTypeEnum {
	
	STARTED("STARTED"),
	FINISHED("FINISHED");

	private String value;

	LogTypeEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
