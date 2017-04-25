package com.group3.model.db.service;

import java.sql.SQLException;

import com.group3.model.db.dao.UserDAO;
import com.model.User;

public class UserDAOService extends DAOService{
	
	UserDAO dao;
	public UserDAOService(){
		dao = new UserDAO(con);
	}
	
	public String getPassword(String email){
		
		String password = "";
		
		try {
			password = dao.getPassword(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return password;
	}
	
	public User getUser(String email){
		
		User user = new User();
		
		try{
			user = dao.getUser(email);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static void main(String[] args) {
		
		UserDAOService service = new UserDAOService();
		String password = service.getPassword("bienjames.octura@gmail.com");
		System.out.println("password="+password);
	}
	
	
	

}
