package connectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	
	private static final String URL = "jdbc:sqlserver://localhost;databaseName=QuanLyMuaBanLinhKien;user=sa;password=sapassword";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
	
}