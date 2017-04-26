package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.constants.ColumnConstants;
import com.model.Gender;
import com.model.User;

public class UserDAO extends DAO{

	public UserDAO(Connection con) {
		super(con);
	}
	
	
	public String getPassword(String email) throws SQLException{
		
		String password = "";
		String SELECT_ROOMBYID = "SELECT password FROM users WHERE email=?";
		PreparedStatement pstmt = con.prepareStatement(SELECT_ROOMBYID);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
        while (rs.next()) {
            password = rs.getString("password");
        }
		pstmt.close();
		
		return password;
		
	}
	public String getPasswordByName(String name) throws SQLException{
		
		String password = "";
		String SELECT_ROOMBYID = "SELECT password FROM users WHERE fullname=?";
		PreparedStatement pstmt = con.prepareStatement(SELECT_ROOMBYID);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			password = rs.getString("password");
		}
		pstmt.close();
		
		return password;
		
	}
	

	public int insertUser(User user){  
	    int i = 0;  
	    String INSERT_USER = "INSERT INTO users (" 
	    + ColumnConstants.EMAIL + "," 
	    + ColumnConstants.PASSWORD + ","
	    + ColumnConstants.FULL_NAME + ","
	    + ColumnConstants.GENDER + ","
	    + ColumnConstants.STATE + ","
	    + ColumnConstants.ZIP + ""
	    + ") VALUES (?,?,?,?,?,?)";	   
//	    String INSERT_USER = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?,?,?)";	   
	    
	    try {  
	        PreparedStatement preStmt =con.prepareStatement(INSERT_USER);  
	        preStmt.setString(1, (user.getEmail()));  
	        preStmt.setString(2, (user.getPassword()));  
	        preStmt.setString(3, (user.getFullname()));
	        preStmt.setInt(4, (user.getGender()));
	        preStmt.setString(5, (user.getState()));
	        preStmt.setInt(6, (user.getZip()));
	        i = preStmt.executeUpdate();  
	    }  catch (SQLException e)  {  
	        e.printStackTrace();  
	    }  
	    return i; //return the updated rows,1 means excuted ok  
	}  	
	
	public int saveUser(User user){  
	    int i = 0;  
	    String UPDATE_USER = "UPDATE users set " 
	    + ColumnConstants.EMAIL + "=?," 
	    + ColumnConstants.PASSWORD + "=?,"
	    + ColumnConstants.FULL_NAME + "=? where userid=?";	
	    System.out.println("user.getId()"+user.getId());
	    try {  
	        PreparedStatement preStmt =con.prepareStatement(UPDATE_USER);  
	        preStmt.setString(1,(user.getEmail()));  
	        preStmt.setString(2,(user.getPassword()));  
	        preStmt.setString(3,(user.getFullname())); 
	        preStmt.setInt(4,(user.getId()));  
	        i = preStmt.executeUpdate();  
	    }  catch (SQLException e)  {  
	        e.printStackTrace();  
	    }  
	    return i; //return the updated rows,1 means excuted ok  
	}  	
	
	public User getUser(String email) throws SQLException{
		
		User user = new User();
		String SELECT_USER = "SELECT "
				+ ColumnConstants.USER_ID+","
				+ ColumnConstants.FULL_NAME+","
				+ ColumnConstants.GENDER+","
				+ ColumnConstants.STATE+","
				+ ColumnConstants.CITY+","
				+ ColumnConstants.STREET+","
				+ ColumnConstants.ZIP+","
				+ ColumnConstants.BIRTH_YEAR+","
				+ ColumnConstants.EMAIL+","
				+ ColumnConstants.PASSWORD+" "
				+ "FROM users where email=?";
		
		PreparedStatement pstmt = con.prepareStatement(SELECT_USER);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			user.setId(rs.getInt(ColumnConstants.USER_ID));
			user.setFullname(rs.getString(ColumnConstants.FULL_NAME));
			user.setState(rs.getString(ColumnConstants.STATE));
			user.setCity(rs.getString(ColumnConstants.CITY));
			user.setStreet(rs.getString(ColumnConstants.STREET));
			user.setZip(rs.getInt(ColumnConstants.ZIP));
			user.setBirthYear(rs.getInt(ColumnConstants.BIRTH_YEAR));
			user.setEmail(rs.getString(ColumnConstants.EMAIL));
			user.setPassword(rs.getString(ColumnConstants.PASSWORD));
			
			user.setGender(rs.getInt(ColumnConstants.GENDER));
		}
		
		return user;
	}
	public User getUserByName(String fullName) throws SQLException{
		
		User user = new User();
		String SELECT_USER = "SELECT "
				+ ColumnConstants.USER_ID+","
				+ ColumnConstants.FULL_NAME+","
				+ ColumnConstants.GENDER+","
				+ ColumnConstants.STATE+","
				+ ColumnConstants.CITY+","
				+ ColumnConstants.STREET+","
				+ ColumnConstants.ZIP+","
				+ ColumnConstants.BIRTH_YEAR+","
				+ ColumnConstants.EMAIL+","
				+ ColumnConstants.PASSWORD+" "
				+ "FROM users where fullname=?";
		
		PreparedStatement pstmt = con.prepareStatement(SELECT_USER);
		pstmt.setString(1, fullName);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			user.setId(rs.getInt(ColumnConstants.USER_ID));
			user.setFullname(rs.getString(ColumnConstants.FULL_NAME));
			user.setState(rs.getString(ColumnConstants.STATE));
			user.setCity(rs.getString(ColumnConstants.CITY));
			user.setStreet(rs.getString(ColumnConstants.STREET));
			user.setZip(rs.getInt(ColumnConstants.ZIP));
			user.setBirthYear(rs.getInt(ColumnConstants.BIRTH_YEAR));
			user.setEmail(rs.getString(ColumnConstants.EMAIL));
			user.setPassword(rs.getString(ColumnConstants.PASSWORD));
			
			user.setGender(rs.getInt(ColumnConstants.GENDER));
		}
		
		return user;
	}

}
