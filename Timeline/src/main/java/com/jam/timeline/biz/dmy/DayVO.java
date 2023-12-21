package com.jam.timeline.biz.dmy;

public class DayVO {
	private int day_id;
	private String username;
	private int day_value;
	
	public int getDay_id() {
		return day_id;
	}
	public void setDay_id(int day_id) {
		this.day_id = day_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDay_value() {
		return day_value;
	}
	public void setDay_value(int day_value) {
		this.day_value = day_value;
	}
	
	@Override
	public String toString() {
		return "DayVO [day_id=" + day_id + ", username=" + username + ", day_value=" + day_value + "]";
	}
}
