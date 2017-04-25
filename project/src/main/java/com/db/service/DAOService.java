package com.db.service;

import java.sql.Connection;

import com.db.DBConnection;

public class DAOService {
	
	protected Connection con;
	
	//DB Singleton Instance is initialized here.
	protected DAOService() {
		con = DBConnection.getInstance().getConnection();
	}

}
