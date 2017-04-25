package com.model;

/* extended comment obj to include the user name(the email addr) */
public class CommentVO extends Comment {
	private String email;
	
	public CommentVO(){
		
	}
	
	public CommentVO(Comment comment){
		this.setComment(comment.getComment());
		this.setCommentid(comment.getCommentid());
		this.setDateCreated(comment.getDateCreated());
		this.setDateUpdated(comment.getDateUpdated());
		this.setPostid(comment.getPostid());
		this.setUserid(comment.getUserid());
		
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
