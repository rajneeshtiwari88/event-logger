package com.credit.suisse.eventlogger.bean;

import java.security.Timestamp;

import com.credit.suisse.eventlogger.enums.LogTypeEnum;

public class EventLogger {
	
	private String id;
	private LogTypeEnum state;
	private String type;
	private Timestamp timestamp;
	private String host;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LogTypeEnum getState() {
		return state;
	}
	public void setState(LogTypeEnum state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}	

}
