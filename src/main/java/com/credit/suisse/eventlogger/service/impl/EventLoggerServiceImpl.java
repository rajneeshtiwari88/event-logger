package com.credit.suisse.eventlogger.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.credit.suisse.eventlogger.bean.EventLogger;
import com.credit.suisse.eventlogger.repository.EventLoggerRepository;
import com.credit.suisse.eventlogger.service.EventLoggerService;
import com.credit.suisse.eventlogger.util.EventLoggerUtility;

public class EventLoggerServiceImpl implements EventLoggerService {

	private Logger logger = LoggerFactory.getLogger(EventLoggerServiceImpl.class);

	@Autowired
	private EventLoggerRepository eventLoggerRepository;

	@Autowired
	private EventLoggerUtility utility;

	@Override
	public List<String> loadFile(String fileName) {
		logger.info("Start loadFile for fileName: {}", fileName);
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			logger.error("Exception while reading file: {}", e.getMessage());
		}
		logger.info("End loadFile for fileName: {}", fileName);
		return lines;
	}

	@Override
	public void saveDetails(List<String> logDetails) {
		logger.info("Start saveDetails for logDetails");
		for (String logDetail : logDetails) {
			EventLogger eventLogger = utility.convertJsonStringToObject(logDetail);
			logger.debug("Event Logger Id: {}", eventLogger.getId());
			com.credit.suisse.eventlogger.entity.EventLogger loggerEntity = eventLoggerRepository
					.findByEventId(eventLogger.getId());
			if (Objects.nonNull(loggerEntity)) {
				if (eventLogger.getTimestamp().getTimestamp()
						.compareTo(loggerEntity.getEventDuration().getTimestamp()) >= 4) {
					loggerEntity.setEventAlert(true);
					eventLoggerRepository.save(loggerEntity);
				}
			} else {
				loggerEntity = new com.credit.suisse.eventlogger.entity.EventLogger();
				loggerEntity.setEventDuration(eventLogger.getTimestamp());
				loggerEntity.setEventHost(eventLogger.getHost());
				loggerEntity.setEventId(eventLogger.getId());
				loggerEntity.setEventType(eventLogger.getState().getValue());
				eventLoggerRepository.save(loggerEntity);
			}
		}
	}
}
