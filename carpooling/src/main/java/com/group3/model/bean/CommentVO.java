package com.group3.model.bean;

/* extended comment obj to include the user name(the email addr) */
public class CommentVO extends Comment {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
