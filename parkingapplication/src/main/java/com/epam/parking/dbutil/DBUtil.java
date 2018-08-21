package com.epam.parking.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	Connection con=null;
		/* private static String dbURL = "jdbc:mysql://localhost:3306/parkingarea";
		 
		 private static String dbUser = "root";
		

	     private static String dbPass = "Epam123$$";
	     //Password
		static Connection con=null;
		//create a connection object
		/*
		 * This method will establish a connection to the database and return the java.sql.Connection reference
		 */
	public  Connection getDBConn() throws SQLException, ClassNotFoundException{
		try {
		//Class.forName("com.mysql.jdbc.Driver");
		// The driver class for the mysql database.
		
//		 con = DriverManager.getConnection(dbURL, dbUser, dbPass);
		 //Establish a connection with mysql database 

		
		/*
		 * If any abnormal condition occurs stack trace will be displayed
		 */
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/parkingarea","root","Epam123$$");
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		return con;
		}
	


}
	

