package com.vtiger.comcast.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	public void connectToDatabase() throws SQLException {
		
//		//register the driver
//		Driver driver=new Driver();
//		DriverManager.registerDriver(driver);
//		
//		//get connection with the Database
//		Connection con = DriverManager.getConnection(null, null, null);
//		
//		//issue create statement
//		Statement state = con.createStatement();
//		
//		//excute a query- 
//		ResultSet result = state.executeQuery(null);
//		
		System.out.println("Connected to databasae");
		
	}
	public void closeDatabase() {
		System.out.println("Databse closed");
	}

}
