package com.db.service;

import java.sql.SQLException;

import com.db.dao.UserDAO;
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
	
	public String getPasswordByName(String name){
		
		String password = "";
		
		try {
			password = dao.getPasswordByName(name);
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
	
	public int registUser(User user){
		int rows = 0;		
		rows = dao.insertUser(user);		
		return rows;
	}
	
	public int saveUser(User user){
		int rows = 0;		
		rows = dao.saveUser(user);		
		return rows;
	}	
	
	
	public static void main(String[] args) {
		
		UserDAOService service = new UserDAOService();
		String password = service.getPassword("bienjames.octura@gmail.com");
		System.out.println("password="+password);
	}
	
	
	

}
