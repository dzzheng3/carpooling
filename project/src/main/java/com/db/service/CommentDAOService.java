package com.db.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.dao.CommentDAO;
import com.model.Comment;
import com.model.CommentVO;
import com.model.Post;
import com.model.PostType;
import com.model.PostVO;

public class CommentDAOService extends DAOService {

	CommentDAO dao;

	public CommentDAOService() {
		dao = new CommentDAO(con);
	}

	public List<CommentVO> getComments(int postId, int length) {

		List<CommentVO> comm = new ArrayList<>();
		try {
			comm = dao.getComments(postId, length);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comm;
	}

	public Comment addComment(Comment comm) {

		try {
			comm = dao.addPost(comm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comm;
	}
	
	public void deleteComment(int commentId){
		
		try {
			dao.deleteComment(commentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
