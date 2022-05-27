package mysqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
//
//	private static String dbhost = "jdbc:mysql://localhost:3306/empdb";
//	private static String username = "root";
//	private static String password = "Mansi@321";
//	private static Connection conn;
//	
//	@SuppressWarnings("finally")
//	public static Connection createNewDBconnection() {
//		try  {	
//			conn = DriverManager.getConnection(
//					dbhost, username, password);	
//		} catch (SQLException e) {
//			System.out.println("Cannot create database connection");
//			e.printStackTrace();
//		} finally {
//			return conn;	
//		}		
//	}
//	public static Boolean validateUser(String username,String password) throws SQLException {
//		Boolean status=false;
//		try{
//
//		PreparedStatement ps = conn.prepareStatement("select * from employee where emp_name = ? and password = ?;");
////		ps = conn.prepareStatement(password)
//		ps.setString(1,username);
//		ps.setString(2, password);
//		ResultSet rs = ps.executeQuery();
//		status=rs.next();
//		System.out.print(rs);
//		
//		}
//		catch(Exception e){System.out.println(e);}
//		return status; 
//		}
}
