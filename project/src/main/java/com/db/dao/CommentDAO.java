package com.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.constants.ColumnConstants;
import com.model.Comment;
import com.model.CommentVO;
import com.model.Like;
import com.model.Post;
import com.model.PostType;
import com.model.PostVO;
import com.mysql.jdbc.Statement;
import com.utils.ConverterUtil;

public class CommentDAO extends DAO {

	public CommentDAO(Connection con) {
		super(con);
	}

	public List<CommentVO> getComments(int postId, int length) throws SQLException {

		List<CommentVO> comments = new ArrayList<>();
		
		String SELECT_COMM ="select c.*,u.email from comments c, users u "+
				" where c.postid=? and c.userid=u.userid limit ?";

		PreparedStatement stmt = con.prepareStatement(SELECT_COMM);
		stmt.setInt(1, postId);
		stmt.setInt(2, length);
		System.out.println("SELECT COMMENT QUERY:"+stmt.toString());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			CommentVO comm = new CommentVO();
			comm.setPostid(rs.getInt(ColumnConstants.POST_ID));
			comm.setCommentid(rs.getInt(ColumnConstants.COMMNET_ID));
			comm.setComment(rs.getString(ColumnConstants.COMMENT));
			comm.setUserid(rs.getInt(ColumnConstants.USER_ID));
			comm.setDateUpdated(rs.getDate(ColumnConstants.DATE_UPDATED));
			comm.setDateCreated(rs.getDate(ColumnConstants.DATE_CREATED));
			comm.setEmail(rs.getString(ColumnConstants.EMAIL));

			comments.add(comm);
		}
		return comments;
	}

	public void deleteComment(int commentid) throws SQLException{
		
		String DELETE_COM = "DELETE FROM comments where commentid=?";
		PreparedStatement stmt = con.prepareStatement(DELETE_COM);
		stmt.setInt(1, commentid);
		System.out.println("DELETE COMMENT===>"+stmt.toString());
		stmt.executeUpdate();
	}
	public Comment addPost(Comment comm) throws SQLException{
		
		String INSERT_COMM = "INSERT INTO comments("		
				+ ColumnConstants.USER_ID+","
				+ ColumnConstants.POST_ID+","
				+ ColumnConstants.COMMENT+","
				+ ColumnConstants.DATE_CREATED+")"
				+ "VALUES(?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(INSERT_COMM,Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, comm.getUserid());
		stmt.setInt(2, comm.getPostid());
		stmt.setString(3, comm.getComment());
		Date dateNow = new Date(System.currentTimeMillis());
		stmt.setDate(4,dateNow);
		
		System.out.println(" ADD COMMENT QUERY =="+stmt.toString());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()){
			comm.setCommentid(rs.getInt(1));
			comm.setDateCreated(dateNow);
		}
		return comm;
	}
		
	
}
