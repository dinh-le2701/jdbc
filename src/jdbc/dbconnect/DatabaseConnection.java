package jdbc.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection con = null;
	public static DatabaseConnection instance = new DatabaseConnection();
	
	public static DatabaseConnection getInstance() {
		return instance;
	}
	
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLLop";
		String username = "sa";
		String password = "sapassword";
		
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connect to SQL Server Successfully!");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		System.out.println("Ket noi thanh cong!");
		return con;
	}
	
	public void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
}
