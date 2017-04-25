package com.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.constants.ColumnConstants;
import com.model.Like;
import com.model.Post;
import com.model.PostType;
import com.model.PostVO;
import com.utils.ConverterUtil;

import javafx.geometry.Pos;

public class PostDAO extends DAO{

	public PostDAO(Connection con) {
		super(con);
	}

	public Post getPostById(int postId) throws SQLException{
		Post post = new Post();
		String SELECT = "select * from posts where postid=?";
		PreparedStatement stmt = con.prepareStatement(SELECT);
		stmt.setInt(1, postId);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			
			post.setPostid(rs.getInt(ColumnConstants.POST_ID));
			post.setPost(rs.getString(ColumnConstants.POST));
			post.setUserid(rs.getInt(ColumnConstants.USER_ID));
			post.setType(ConverterUtil.
					intConvertToType(rs.getInt(ColumnConstants.POST_TYPE)));
			post.setDateUpdated(rs.getDate(ColumnConstants.DATE_UPDATED));
			post.setDateCreated(rs.getDate(ColumnConstants.DATE_CREATED));
			post.setSource(rs.getString(ColumnConstants.SOURCE));
			post.setDestination(rs.getString(ColumnConstants.DESTINATION));
			
		}
		
		return post;
	}
	
	public List<PostVO> getPosts(PostType type, int length, int lastIndex) throws SQLException{
		return getPosts(type, length, lastIndex, "");		
	}
	
	//add by paul to support the search function
	public List<PostVO> getPosts(PostType type, int length, int lastIndex, String destination) throws SQLException{
		//TODO: comment send the post id
		List<PostVO> posts = new ArrayList<>();
//		String SELECT_POST = "SELECT * FROM posts where"
//				+ " posttype=? and postid>? limit ?";
		
		lastIndex = lastIndex == 0 ? Integer.MAX_VALUE : lastIndex;  //if it's first time it will be 0 then make it to the Max
		
		String SELECT_POST = "select p.*,u.email from posts p, users u "
				+ "where p.posttype=? and p.postid<? and p.userid=u.userid and LOWER(p.destination) like ? order by p.postid desc limit ?";
		
		destination = "%"+ destination + "%";
		
		PreparedStatement stmt = con.prepareStatement(SELECT_POST);
		int typeInt = ConverterUtil.typeConvertToInt(type);
		stmt.setInt(1, typeInt);
		stmt.setInt(2, lastIndex);
		stmt.setString(3, destination.toLowerCase());
		stmt.setInt(4, length);
		
		System.out.println("Executing Query.. ="+stmt.toString());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			PostVO post = new PostVO();
			post.setPostid(rs.getInt(ColumnConstants.POST_ID));
			post.setPost(rs.getString(ColumnConstants.POST));
			post.setUserid(rs.getInt(ColumnConstants.USER_ID));
			post.setType(ConverterUtil.
					intConvertToType(rs.getInt(ColumnConstants.POST_TYPE)));
			post.setDateUpdated(rs.getDate(ColumnConstants.DATE_UPDATED));
			post.setDateCreated(rs.getDate(ColumnConstants.DATE_CREATED));
			post.setSource(rs.getString(ColumnConstants.SOURCE));
			post.setDestination(rs.getString(ColumnConstants.DESTINATION));
			post.setEmail(rs.getString(ColumnConstants.EMAIL));
			
			LikeDAO likeDao = new LikeDAO(con);
			Like like = likeDao.getLike(post.getUserid(), post.getPostid());
			if(like.getLikeid()>0){
				post.setLiked(true);
			}
			posts.add(post);
		}
		return posts;
	}
	
	public Post addPost(Post post) throws SQLException{
		
		String INSERT_POST = "INSERT INTO posts("
				+ ColumnConstants.USER_ID+","
				+ ColumnConstants.POST+","
				+ ColumnConstants.SOURCE+","
				+ ColumnConstants.DESTINATION+","
				+ ColumnConstants.POST_TYPE+","
				+ ColumnConstants.DATE_CREATED+")"
				+ "VALUES(?,?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(INSERT_POST);
		stmt.setInt(1, post.getUserid());
		stmt.setString(2, post.getPost());
		stmt.setString(3, post.getSource());
		stmt.setString(4, post.getDestination());
		stmt.setInt(5, ConverterUtil.typeConvertToInt(post.getType()));
		stmt.setDate(6,new Date(System.currentTimeMillis()));
		
		stmt.executeUpdate();
//		con.commit();
//		TODO: do we need to get generated sequence?
		return post;
	}

	


}
