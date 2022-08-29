package com.credit.suisse.eventlogger.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credit.suisse.eventlogger.service.EventLoggerService;

@RestController
@RequestMapping("/v1/eventlogger")
public class EventLoggerController {
	
	@Autowired
	private EventLoggerService eventLoggerService;
	
	
	private Logger logger = LoggerFactory.getLogger(EventLoggerController.class);
	
	@GetMapping(path = "/logfile/{filename:.+}")
	public void getLogFile(@PathVariable String fileName) {
		logger.info("Start getLogFile: ", fileName);
		List<String> logDetails = eventLoggerService.loadFile(fileName);
		eventLoggerService.saveDetails(logDetails);
		
	}

}
