package co.edu.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public PreparedStatement psmt;

	// Connection 객체 반환해주는 getConnect
	public Connection getConnect() {
		try {
			
			Properties prop = new Properties();
			prop.load(new FileReader("src/main/java/co/edu/database.properties"));
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String pass = prop.getProperty("passwd");
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결실패");
		}
		return conn;
	}

	// Resource를 해제해주는 disConnect
	public void disconnect() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
