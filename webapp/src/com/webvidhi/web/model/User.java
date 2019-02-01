package com.webvidhi.web.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	String userName;
	
	Long id;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
