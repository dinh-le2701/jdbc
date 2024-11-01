package jdbc;

import jdbc.dbconnect.DatabaseConnection;

public class Main {
	
	public static DatabaseConnection connection = new DatabaseConnection();
	public static void main(String[] args) {
		connection.connect();
	}
}
