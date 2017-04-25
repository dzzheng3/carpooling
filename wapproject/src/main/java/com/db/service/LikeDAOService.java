package com.db.service;

import java.sql.SQLException;

import com.db.dao.LikeDAO;
import com.model.Like;

public class LikeDAOService extends DAOService{
	
	private LikeDAO dao;
	
	public LikeDAOService() {
		dao = new LikeDAO(con);
	}
	
	public Like getLike(int userid, int postid){
		
		Like like = new Like();
		
		try {
			like = dao.getLike(userid, postid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return like;
	}
	
	public Like setLike(int postId,int userId){
		
		Like like = new Like();
		try {
			like = dao.setLike(postId,userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return like;
	}
	
	public static void main(String[] args) {
		LikeDAOService dao = new LikeDAOService();
		Like like = dao.setLike(1, 1);
		
		System.out.println("Liked="+like.getLikeid());
	}

}
