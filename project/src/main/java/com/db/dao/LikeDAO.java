package com.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.constants.ColumnConstants;
import com.model.Like;
import com.mysql.jdbc.Statement;

public class LikeDAO extends DAO{

	public LikeDAO(Connection con) {
		super(con);
	}
	
	public Like getLike(int userid,int postid) throws SQLException{
		
		Like like = new Like();
		
		String SELECT_LIKE = "SELECT * FROM likes WHERE userid=? AND postid=?";
		
		PreparedStatement pstmt = con.prepareStatement(SELECT_LIKE);
		pstmt.setInt(1, userid);
		pstmt.setInt(2, postid);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			like.setLikeid(rs.getInt(ColumnConstants.LIKE_ID));
			like.setPostid(rs.getInt(ColumnConstants.POST_ID));
			like.setUserid(rs.getInt(ColumnConstants.USER_ID));
		}
		return like;
	}
	
	public Like setLike(int postId, int userId) throws SQLException{
		
		String INSERT_LIKE = "INSERT INTO likes("
				+ ColumnConstants.USER_ID+","
				+ ColumnConstants.POST_ID+","
				+ ColumnConstants.DATE_CREATED+")"
				+ "VALUES (?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(INSERT_LIKE,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, postId);
		pstmt.setInt(2, userId);
		pstmt.setDate(3, new Date(System.currentTimeMillis()));
		
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		Like like = new Like();
		if(rs.next()){
			like.setLikeid(rs.getInt(1));
			like.setPostid(postId);
			like.setUserid(userId);
		}
		
		
		return like;
	}
	
	

}
