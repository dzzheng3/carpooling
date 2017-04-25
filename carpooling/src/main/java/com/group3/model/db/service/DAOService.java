package com.group3.model.db.service;

import java.sql.Connection;

import com.group3.model.db.DBConnection;

public class DAOService {
	
	protected Connection con;
	
	//DB Singleton Instance is initialized here.
	protected DAOService() {
		con = DBConnection.getInstance().getConnection();
	}

}
