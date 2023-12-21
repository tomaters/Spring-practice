package com.jam.timeline.biz.dmy;

public class MonthVO {
	
	private int month_id;
	private String username;
	private String month_value;
	
	public int getMonth_id() {
		return month_id;
	}
	public void setMonth_id(int month_id) {
		this.month_id = month_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMonth_value() {
		return month_value;
	}
	public void setMonth_value(String month_value) {
		this.month_value = month_value;
	}
	
	@Override
	public String toString() {
		return "UserVO [month_id=" + month_id + ", username=" + username + ", month_value=" + month_value + "]";
	}
}
