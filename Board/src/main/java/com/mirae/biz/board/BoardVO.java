package com.mirae.biz.board;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="myboard")
public class BoardVO {
	@Id
	@GeneratedValue
	private int sequence;
	private String title;
	private String username;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date regDate =new Date();
	private int count;
	@Transient
	private String searchCondition;
	@Transient
	private String searchKeyword;
	// to use, import library from MVN Repository: Apache Commons FileUpload into pom.xml
	// also need to set MultipartResolver in presentation-layer.xml
	@Transient
	private MultipartFile uploadFile; 

	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
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
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	@Override
	public String toString() {
		return "BoardVO [sequence=" + sequence + ", title=" + title + ", username=" + username + ", content=" + content
				+ ", regDate=" + regDate + ", count=" + count + ", searchCondition=" + searchCondition
				+ ", searchKeyword=" + searchKeyword + ", uploadFile=" + uploadFile + "]";
	}	
}
