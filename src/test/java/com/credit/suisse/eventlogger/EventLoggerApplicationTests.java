package com.credit.suisse.eventlogger;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.credit.suisse.eventlogger.repository.EventLoggerRepository;
import com.credit.suisse.eventlogger.service.impl.EventLoggerServiceImpl;
import com.credit.suisse.eventlogger.util.EventLoggerUtility;

@SpringBootTest
class EventLoggerApplicationTests {

	@InjectMocks
	private EventLoggerServiceImpl eventLoggerServiceImpl;
	
	@Mock
	private EventLoggerRepository eventLoggerRepository;
	
	@Mock
	private EventLoggerUtility utility;
	
	public void loadFileTest() {
		
	}

}
