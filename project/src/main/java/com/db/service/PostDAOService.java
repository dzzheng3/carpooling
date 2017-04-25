package com.db.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.dao.PostDAO;
import com.model.Post;
import com.model.PostType;
import com.model.PostVO;

public class PostDAOService extends DAOService{
	
	PostDAO dao;
	public PostDAOService(){
		dao = new PostDAO(con);
	}
	
	public List<PostVO> getPosts(PostType type, int length, int lastIndex){
		return getPosts(type, length, lastIndex, "");
	}
	
	public List<PostVO> getPosts(PostType type, int length, int lastIndex, String destination){
		List<PostVO> posts = new ArrayList<>();
		try {
			posts = dao.getPosts(type, length, lastIndex, destination);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return posts;
	}
	
	public Post addPost(Post post){
		
		try {
			post = dao.addPost(post);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}
	
	public static void main(String[] args) {
		
			
		PostDAOService service = new PostDAOService();
		
//		Post newPost = new Post();
//		newPost.setUserid(1);
//		newPost.setPost("TEST POST!");
//		newPost.setSource("Fairfield,IA");
//		newPost.setDestination("Fairfield,IA");
//		newPost.setType(PostType.OFFERING);
//		
//		service.addPost(newPost);
		
//		SELECT * FROM posts where posttype=1 and postid>4 limit 2;
		List<PostVO> posts = service.getPosts(PostType.OFFERING, 3, 4);
		for (PostVO post : posts) {
			System.out.println("POST: "+post.getPost());
			System.out.println("POST email: "+post.getEmail());
			System.out.println("POST liked: "+post.getLiked());
		}
	}

}
