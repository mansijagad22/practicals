package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import config.DbConnection;

public class LoginDAO {
	public LoginDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	static Connection con = DbConnection.getConnection();

	public boolean checkPassword(String username, String password) {
		String correctPassword = null;
		System.out.println("user entered password is: " + password);
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select password from employee where emp_name ='"+username+"'");
			System.out.println(ps);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				correctPassword = rs.getString(1);
				System.out.println("password in the database is :" + correctPassword);
			}
			else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Base64.Decoder decoder = Base64.getDecoder();
		// Decoding string
		String decodedPassword = new String(decoder.decode(correctPassword));
		System.out.println(" in checking password Decoded string: " + decodedPassword);

		if (decodedPassword == null) {
			return false;
		} else if (decodedPassword.equals(password)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkIsAdmin(int empId) {
		String checkIsAdmin = null;
		try {
			PreparedStatement ps = con
					.prepareStatement("select is_admin from employee where emp_id = ?");
			ps.setInt(1, empId);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				checkIsAdmin = rs.getString(1);
			}
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (checkIsAdmin.equals("1")) {
			return true;
		} else {
			return false;
		}

	}

	public int getId(String username) {
		int id = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("select emp_id from employee where emp_name = '" + username + "'");
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
