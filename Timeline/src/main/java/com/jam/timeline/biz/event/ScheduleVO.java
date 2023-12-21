package com.jam.timeline.biz.event;

public class ScheduleVO {
	private int schedule_id;
	private String username;
	private int day_id;
	private int event_id;
	private String hour_value;
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDay_id() {
		return day_id;
	}
	public void setDay_id(int day_id) {
		this.day_id = day_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getHour_value() {
		return hour_value;
	}
	public void setHour_value(String hour_value) {
		this.hour_value = hour_value;
	}
	
	@Override
	public String toString() {
		return "ScheduleVO [schedule_id=" + schedule_id + ", username=" + username + ", day_id=" + day_id
				+ ", event_id=" + event_id + ", hour_value=" + hour_value + "]";
	}
}
