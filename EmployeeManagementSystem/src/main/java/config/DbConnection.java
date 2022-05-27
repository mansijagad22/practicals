package config;

import java.sql.*;

public class DbConnection {

	private static Connection con = null;

	static {
		String url = "jdbc:mysql://127.0.0.1:3306/empdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=IST";

//	        String url = "jdbc:mysql://127.0.0.1:3306/empdb?useSSL=false";
		String user = "root";
		String pass = "Mansi@321";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
//	public Statement executeStatement() {
//		try {
//			return con.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
