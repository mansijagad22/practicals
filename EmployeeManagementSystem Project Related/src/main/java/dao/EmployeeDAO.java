package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import config.DbConnection;
import entity.Employee;
import entity.Project;

public class EmployeeDAO {

	public EmployeeDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	static Connection con = DbConnection.getConnection();

	// get all the project with its all information
		public List<Employee> selectAllEmp() {
			List<Employee> empList = new ArrayList<>();
//			List<Project> newProjectList = new ArrayList<Project>();
			try {
				PreparedStatement ps = con.prepareStatement("select * from employee");
				System.out.println(ps + " end");
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int empId = rs.getInt("emp_id");
					String empName = rs.getString("emp_name");
					String mob = rs.getString("mob_no");
					Date dob = rs.getDate("dob");
					String hobbies = rs.getString("hobbies");
					int isAdmin = rs.getInt("is_admin");
					String email = rs.getString("email");
					int addressId = rs.getInt("address_id");
					Employee e = new Employee();
					e.setEmpId(empId);
					e.setEmpName(empName);
					e.setMobNo(mob);
					e.setDob((java.sql.Date) dob);
					e.setHobbies(hobbies);
					e.setIsAdmin(isAdmin);
					e.setEmail(email);
					e.setAddressId(addressId);
					empList.add(e);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("last line on projectdao " + projectList);
			return empList;
		}
	
	public int selectEmployeeIdByName(String username) {
		int empId = 0;
		try {

			String query = "select emp_id from employee where emp_name= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				String name = rs.getString("project_name");
				empId = rs.getInt("emp_id");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}

		return empId;
	}

	public Employee getEmpDetailById(int id) throws SQLException {
		Base64.Decoder decoder = Base64.getDecoder();
		Employee emp = new Employee();
		PreparedStatement ps = con.prepareStatement("select * from employee where emp_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		String decryptPassword = "";
		while (rs.next()) {
			int empId = rs.getInt("emp_id");
			String empName = rs.getString("emp_name");
			String mob = rs.getString("mob_no");
			Date dob = rs.getDate("dob");
			String hobbies = rs.getString("hobbies");
			int isAdmin = rs.getInt("is_admin");
			String email = rs.getString("email");
			int projectId = rs.getInt("project_id");
			String password = rs.getString("password");

			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setMobNo(mob);
			emp.setDob((java.sql.Date) dob);
			emp.setHobbies(hobbies);
			emp.setIsAdmin(isAdmin);
			emp.setEmail(email);
			emp.setProjectId(projectId);
			decryptPassword = new String(decoder.decode(password));
			emp.setPassword(decryptPassword);
		}
		return emp;
	}

	public Boolean updateEmpDetails(Employee e) {
		boolean rowUpdated = false;
		PreparedStatement ps;
		try {
//			ps = con.prepareStatement("update employee set password=?,"
//					+ "mob_no=?,"
//					+ "dob=?,"
//					+ "address1=?,"
//					+ "address2=?,"
//					+ "hobbies=?,"
//					+ "is_admin=?,"
//					+ "project_id =?"
//					+ "where"
//					+ " emp_id = ?");

			ps = con.prepareStatement(
					"UPDATE employee SET mob_no= ?,dob=?,hobbies=?,is_admin=?,password=? where emp_id=?");
			ps.setString(1, e.getMobNO());
			ps.setDate(2, e.getDob());
			ps.setString(3, e.getHobbies());
			ps.setInt(4, e.getIsAdmin());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.getEmpId());
			rowUpdated = ps.executeUpdate() > 0;

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return rowUpdated;

	}

	// get all employee list by its id and name
	public List<Employee> selectAllEmployeeNameAndId() {
		List<Employee> empList = new ArrayList<Employee>();
//		List<Project> newProjectList = new ArrayList<Project>();
		try {
			PreparedStatement ps = con.prepareStatement("select emp_id,emp_name from employee order by emp_name asc");
			System.out.println(ps + " end");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int empId = rs.getInt("emp_id");
				System.out.println(empId);
				String empName = rs.getString("emp_name");
				System.out.println(empName);
				empList.add(new Employee(empId, empName));
//				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < empList.size(); i++) {
			System.out.print(empList.get(i).getEmpId());
		}
		return empList;
	}

//	public Boolean updateEmpProjectDetail(int empId) {
//		boolean rowUpdated = false;
//		PreparedStatement ps;
//		try {
////			ps = con.prepareStatement("update employee set password=?,"
////					+ "mob_no=?,"
////					+ "dob=?,"
////					+ "address1=?,"
////					+ "address2=?,"
////					+ "hobbies=?,"
////					+ "is_admin=?,"
////					+ "project_id =?"
////					+ "where"
////					+ " emp_id = ?");
//
//			ps = con.prepareStatement(
//					"UPDATE employee SET project_id=? where emp_id=?");
//			System.out.print(ps);
//			System.out.print(ps);
//			System.out.print(ps);
//			ps.setInt(1, e.getProjectId());
//			ps.setInt(2, e.getEmpId());
//			rowUpdated = ps.executeUpdate() > 0;
//
//		} catch (SQLException ex) {
//			// TODO Auto-generated catch block
//			ex.printStackTrace();
//		}
//		return rowUpdated;
//
//	}
	public Employee findByEmail(String email) throws SQLException {
		Employee emp = new Employee();
		PreparedStatement ps = con.prepareStatement("select * from employee where email = ?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs);
		while (rs.next()) {
			int empId = rs.getInt("emp_id");
			String empName = rs.getString("emp_name");
			String mob = rs.getString("mob_no");
			Date dob = rs.getDate("dob");
			String address1 = rs.getString("address1");
			String address2 = rs.getString("address2");
			String hobbies = rs.getString("hobbies");
			int isAdmin = rs.getInt("is_admin");
			int projectId = rs.getInt("project_id");
			String password = rs.getString("password");

			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setMobNo(mob);
			emp.setDob((java.sql.Date) dob);
			emp.setAddress1(address1);
			emp.setAddress2(address2);
			emp.setHobbies(hobbies);
			emp.setIsAdmin(isAdmin);
			emp.setProjectId(projectId);
			emp.setPassword(password);
		}
		return emp;
	}

	public String findPasswordUsingEmail(String email) throws SQLException {
		Base64.Decoder decoder = Base64.getDecoder();
		String decryptPassword = "";
		Employee emp = new Employee();
		PreparedStatement ps = con.prepareStatement("select password from employee where email = ?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs);
		while (rs.next()) {
			String password = rs.getString("password");
			emp.setPassword(password);
			decryptPassword = new String(decoder.decode(password));
			emp.setPassword(decryptPassword);
		}
		
		return emp.getPassword();
	}

	public Boolean updateEmpPassword(int id, String pass) {
		boolean rowUpdated = false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("UPDATE employee SET password= ? where emp_id=?");

			ps.setString(1, pass);
			ps.setInt(2, id);
			rowUpdated = ps.executeUpdate() > 0;

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return rowUpdated;

	}

	public Boolean updateEmpProjectIdDetail(int empId, int projectId) {
		boolean rowUpdated = false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("UPDATE employee SET project_id= ? where emp_id=?");

			ps.setInt(1, projectId);
			ps.setInt(2, empId);
			rowUpdated = ps.executeUpdate() > 0;

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return rowUpdated;
	}
	
	public int selectLatestEmpId() {
		int m = 0;
		try {
			PreparedStatement ps = con.prepareStatement("select Max(emp_id) as emp_id from employee order by emp_id desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				String name = rs.getString("project_name");
				m = rs.getInt("emp_id");

			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return m;
	}

//	public Boolean checkUserNameExist(String empName) {
//		boolean checkUserExist = false;
//		System.out.println("into check empName exist or not");
//		try {
//			String DbUserName = "";
//			PreparedStatement ps = con.prepareStatement("select emp_name from employee");
//			try {
//				ResultSet rst = executeQuery(ps);
//
//				while (rst.next()) {
//					DbUserName = rst.getString("emp_name");
//					if (empName.equals(DbUserName)) {
//						checkUserExist = true;
//						if (checkUserExist = true)
//							System.out.println(checkUserExist);
//						System.out.println(checkUserExist);
//						System.out.println(checkUserExist);
//						System.out.println(checkUserExist);
//
//						break;
//					}
//				}
//			} catch (SQLException ex) {
//				// TODO Auto-generated catch block
//				ex.printStackTrace();
//			}
//
//			System.out.println();
//			System.out.println();
//			System.out.println(checkUserExist);
//			System.out.println(checkUserExist);
//			System.out.println(checkUserExist);
//		} finally {
//
//			return checkUserExist;
//		}
//
//	}


	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQL State: " + ((SQLException) e).getSQLState());
				System.err.println("Error code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.print("Cause :" + t);
					t = t.getCause();
				}

			}
		}
	}
}
