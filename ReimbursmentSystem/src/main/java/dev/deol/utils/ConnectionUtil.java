package dev.deol.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection createConnection() {
		
		try {
			Properties props= new Properties();
			Class.forName("org.mariadb.jdbc.Driver");
			//ConnectionUtil.class.getClassLoader().getResource("src/main/resources/connection.properties").getFile()
			FileInputStream in = new FileInputStream(ConnectionUtil.class.getClassLoader().getResource("connection.properties").getFile());			
			props.load(in);			
			String details= props.getProperty("condetails");
			
			Connection conn = DriverManager.getConnection(details);
			//System.out.println(conn);
			return conn;
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	
		
	}
}
