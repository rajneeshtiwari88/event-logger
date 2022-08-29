package com.credit.suisse.eventlogger.service;

import java.util.List;

public interface EventLoggerService {

	List<String> loadFile(String fileName);

	void saveDetails(List<String> logDetails);
}
