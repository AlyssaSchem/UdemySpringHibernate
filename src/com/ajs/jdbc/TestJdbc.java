package com.ajs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String userID = "hbstudent";
	    String password = "hbstudent";
		
		try{
			System.out.print("Connecting" + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, userID, password);
			
			System.out.print("connection successful");
			
		} catch (Exception exc){
			exc.printStackTrace();
		}

	}

}
