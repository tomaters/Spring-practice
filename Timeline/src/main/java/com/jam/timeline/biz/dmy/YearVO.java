package com.jam.timeline.biz.dmy;

public class YearVO {

	private int year_id;
	private String username;
	private int year_value;
	public int getYear_id() {
		return year_id;
	}
	public void setYear_id(int year_id) {
		this.year_id = year_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getYear_value() {
		return year_value;
	}
	public void setYear_value(int year_value) {
		this.year_value = year_value;
	}
	
	@Override
	public String toString() {
		return "YearVO [year_id=" + year_id + ", username=" + username + ", year_value=" + year_value + "]";
	}
}
