package com.credit.suisse.eventlogger.util;

import com.credit.suisse.eventlogger.bean.EventLogger;
import com.google.gson.Gson;

public class EventLoggerUtility {
	
	public EventLogger convertJsonStringToObject(String jsonString) {
		Gson g = new Gson();  
		EventLogger eventLogger = g.fromJson(jsonString, EventLogger.class);
		return eventLogger;
	}

}
