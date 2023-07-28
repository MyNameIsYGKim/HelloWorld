package co.micol.noticeprj.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource dataSource = new DataSource();
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;
	
	private DataSource() {
		getProperties();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void getProperties() {
		String resource = "/database.properties";
		Properties properties = new Properties();
		
		InputStream inputStream = getClass().getResourceAsStream(resource);
		try {
			properties.load(inputStream);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
