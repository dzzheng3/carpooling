package com.group3.model.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.constants.ColumnConstants;
import com.group3.utils.ConverterUtil;
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
			
			user.setGender(ConverterUtil.genderConvert(rs.getInt(ColumnConstants.GENDER)));
		}
		
		return user;
	}

}
