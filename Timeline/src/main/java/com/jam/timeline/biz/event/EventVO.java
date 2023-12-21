package com.jam.timeline.biz.event;

import java.sql.Date;
import java.sql.Timestamp;

public class EventVO {

	private int event_id;
	private String username;
	private Date event_date;
	private Timestamp creation_date;
	private Timestamp modified_date;
	private String event_title;
	private String event_desciption;
	private String event_category;
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
	public Timestamp getModified_date() {
		return modified_date;
	}
	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_desciption() {
		return event_desciption;
	}
	public void setEvent_desciption(String event_desciption) {
		this.event_desciption = event_desciption;
	}
	public String getEvent_category() {
		return event_category;
	}
	public void setEvent_category(String event_category) {
		this.event_category = event_category;
	}
	
	@Override
	public String toString() {
		return "EventVO [event_id=" + event_id + ", username=" + username + ", event_date=" + event_date
				+ ", creation_date=" + creation_date + ", modified_date=" + modified_date + ", event_title="
				+ event_title + ", event_desciption=" + event_desciption + ", event_category=" + event_category + "]";
	}
}
