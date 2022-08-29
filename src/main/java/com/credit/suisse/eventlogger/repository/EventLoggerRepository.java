package com.credit.suisse.eventlogger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credit.suisse.eventlogger.entity.EventLogger;

@Repository
public interface EventLoggerRepository extends CrudRepository<EventLogger, Long> {
	
	public EventLogger findByEventId(String eventId);
	
}