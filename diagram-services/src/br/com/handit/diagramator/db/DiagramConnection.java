package br.com.handit.diagramator.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DiagramConnection {

	private Connection connection;

	public Connection getInstance() {
		if (connection == null) {
			System.out.println("-------- Oracle JDBC Connection Testing ------");
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
			}

			System.out.println("Oracle JDBC Driver Registered!");

			connection = null;
			try {
				Properties props = new Properties();
				props.setProperty("user", "handitloghaus");
				props.setProperty("password", "demo");				
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				connection = DriverManager.getConnection(url, props);

			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
			}
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
		}
		return connection;

	}

}
