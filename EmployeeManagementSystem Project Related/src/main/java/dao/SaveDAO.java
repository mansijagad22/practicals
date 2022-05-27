package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import config.DbConnection;
import entity.Employee;
import entity.Project;

public class SaveDAO {
	public SaveDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	static Connection con = DbConnection.getConnection();

	public static int saveEmployee(Employee e) {

		int status = 0;
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(
					"insert into employee (emp_name,"
					+ "mob_no,"
					+ "dob,"
					+ "hobbies,"
					+ "is_admin,"
					+ "email,"
					+ "project_id,"
					+ "password)"
					+ " values "
					+ "(?,?,?,?,?,?,?,?)");

			ps.setString(1, e.getEmpName());
			ps.setString(2, e.getMobNO());
			ps.setDate(3, e.getDob());
			ps.setString(4, e.getHobbies());
			ps.setInt(5, e.getIsAdmin());
			ps.setString(6, e.getEmail());
			ps.setInt(7, e.getProjectId());
			ps.setString(8, e.getPassword());
			status = ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//	     status=ps.executeUpdate();  

		return status;
	}
	public static int saveProjectDetails(Project p) {

		int status = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"insert into project (project_name,project_feature,status) values (?,?,?)");

			ps.setString(1, p.getProjectName());
			ps.setString(2, p.getProjectFeature());
			ps.setString(3,p.getStatus());
			status = ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//	     status=ps.executeUpdate();  

		return status;
	}
	
	public static int update(Employee e) {

		int status = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"update employee set emp_name =?,mob_no=?,dob=?,hobbies=?,is_admin =?,project_id=?,password=?) where emp_id =?");
			ps.executeQuery();
			ps.setString(1, e.getEmpName());
			ps.setString(2, e.getMobNO());
			ps.setDate(3, e.getDob());
			ps.setString(4, e.getHobbies());
			ps.setInt(5, e.getIsAdmin());
			ps.setInt(6, e.getProjectId());
			ps.setString(7, e.getPassword());
			status = ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//	     status=ps.executeUpdate();  

		return status;
	}
}
