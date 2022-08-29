package com.credit.suisse.eventlogger.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "event_logger")
@Entity
public class EventLogger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private Long id;
	
	@Column(name = "event_id", columnDefinition = "varchar(25)", nullable = false)
	private String eventId;
	
	@Column(name = "event_duration", columnDefinition="TIMESTAMP", nullable = false)
	private Timestamp eventDuration;
	
	@Column(name = "event_type", columnDefinition = "varchar(25)", nullable = true)
	private String eventType;
	
	@Column(name = "event_host", columnDefinition = "varchar(25)", nullable = true)
	private String eventHost;
	
	@Column(name = "event_alert", columnDefinition="tinyint(1) default 0")
	private Boolean eventAlert;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}


	public Timestamp getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(Timestamp eventDuration) {
		this.eventDuration = eventDuration;
	}


	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventHost() {
		return eventHost;
	}

	public void setEventHost(String eventHost) {
		this.eventHost = eventHost;
	}

	public Boolean getEventAlert() {
		return eventAlert;
	}

	public void setEventAlert(Boolean eventAlert) {
		this.eventAlert = eventAlert;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventLogger other = (EventLogger) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
