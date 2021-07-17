package com.bank.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {


	private static ConnectionUtil cu;
	private static Properties prop = new Properties();
	
	private ConnectionUtil() {
		
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if (cu == null) {
			return new ConnectionUtil();
		}
		return cu;
	}
	
	public Connection getConnection() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
		String url = "";
		String userName = "";
		String password = "";
		
		try {
			prop.load(is);
			url = (String)prop.getProperty("url");
			userName = (String)prop.getProperty("username");
			password = (String)prop.getProperty("password");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Connection con;
		try {
			//Insert connection here: 
			con = DriverManager.getConnection(url, userName, password);
			return con;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	
		}
}//End ConnectionUtil class 
