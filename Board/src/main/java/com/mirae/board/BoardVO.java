package com.mirae.board;

import java.sql.Date;

public class BoardVO {
	private int sequence;
	private String title;
	private String username;
	private String content;
	private Date regDate;
	private int count;

	public BoardVO() {
		super();
	}
	
	public BoardVO(int sequence, String title, String username, String content, Date regDate, int count) {
		this.sequence = sequence;
		this.title = title;
		this.username = username;
		this.content = content;
		this.regDate = regDate;
		this.count = count;
	}
	
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BoardVO [sequence=" + sequence + ", title=" + title + ", username=" + username + ", content=" + content
				+ ", regDate=" + regDate + ", count=" + count + "]";
	}
}
