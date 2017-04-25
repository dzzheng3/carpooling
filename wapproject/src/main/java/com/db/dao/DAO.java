package com.db.dao;

import java.sql.Connection;

public class DAO {
	
	protected Connection con;
	
	//Only DAO service can create instance of DAO that's why Connection object must be passed
	public DAO(Connection con) {
		super();
		this.con = con;
	}
	

}
