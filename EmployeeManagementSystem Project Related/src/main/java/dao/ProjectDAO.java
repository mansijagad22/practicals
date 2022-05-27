package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import config.DbConnection;
import entity.Project;

public class ProjectDAO {

	public ProjectDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	static Connection con = DbConnection.getConnection();

	// to insert new prooject with default status upcoming
	public void insertProjectNew(Project p) {
		System.out.print("insert into project " + "(project_name,project_feature) " + "values (?,?)");
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into project " + "(project_name,project_feature) " + "values (?,?)");
			ps.setString(1, p.getProjectName());
			ps.setString(2, p.getProjectFeature());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}

	}

//	public void insertProject(Project p) {
//		System.out.print("insert into project "
//				+ "(project_name,project_feature,status) " + "values (?,?,?,?,?)");
//		try {
//			PreparedStatement ps = con.prepareStatement("insert into project "
//					+ "(project_name,project_feature,assign_date,start_date,complete_date) " + "values (?,?,?,?,?)");
//			ps.setString(1, p.getProjectName());
//			ps.setString(2, p.getProjectFeature());
//			ps.setString(3,status);
//
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			printSQLException(e);
//		}
//
//	}
	// select project by its id
	public Project selectProjectById(int projectId) {
		Project p = new Project();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from project where project_id=? ");
			ps.setInt(1, projectId);
			System.out.print(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");

				p = new Project(projectId, name, feature, status);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}

		return p;
	}

	// get all the project with its all information
	public List<Project> selectAllProject() {
		List<Project> projectList = new ArrayList<>();
//		List<Project> newProjectList = new ArrayList<Project>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project");
			System.out.println(ps + " end");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");
////				projectList.add(n)
//				newProjectList.addAll(projectList);
				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("last line on projectdao " + projectList);
		return projectList;
	}

	// to update any field in project
	public Boolean updateProjectDetails(Project p) {
		boolean rowUpdated = false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update project set status=? where project_id =?");
			System.out.print(ps);
			ps.setString(1, p.getStatus());
			ps.setInt(2, p.getProjectId());

			rowUpdated = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;

	}

	//
	public Boolean updateProjectStatusToComplete(int id) {
		boolean rowUpdated = false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update project set status='completed' where project_id =?");
			System.out.print(ps);
			ps.setInt(1, id);

			rowUpdated = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;

	}
	//
	public Boolean updateProjectStatusToOngoing(int id) {
		boolean rowUpdated = false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update project set status='ongoing' where project_id =?");
			System.out.print(ps);
			ps.setInt(1, id);

			rowUpdated = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;

	}

	// to delete any project detail by its id
	public Boolean deleteById(int id) {
		boolean rowDeleted = false;
		boolean rowUpdated = false;

		try {

			PreparedStatement ps1 = con.prepareStatement("update employee  set project_id = null where project_id = ?");
			PreparedStatement ps = con.prepareStatement("delete from project where project_id = ?");
			ps.setInt(1, id);
			ps1.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
			rowUpdated = ps1.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}

	// get all the project in upcoming status
	public List<Project> selectAllUpcoming() {
		List<Project> projectList = new ArrayList<>();
//			List<Project> newProjectList = new ArrayList<Project>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project where status ='upcoming'");
			System.out.println(ps + " end");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");
				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("last line on projectdao " + projectList);
		return projectList;
	}

	// get all the project in ongoing status
	public List<Project> selectAllOngoing() {
		List<Project> projectList = new ArrayList<>();
//					List<Project> newProjectList = new ArrayList<Project>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project where status ='ongoing'");
			System.out.println(ps + " end");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");
				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("last line on projectdao " + projectList);
		return projectList;
	}

	// get all ongoing project for specific employee
	public List<Project> selectAllOngoingForSpecificEmp(int empId) {
		List<Project> projectList = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project p  j" + "oin employee e "
					+ "on p.project_id= e.project_id " + "where status ='ongoing' and emp_id = ?");
			System.out.println(ps + " end");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");
				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("last line on projectdao " + projectList);
		return projectList;
	}

	// get all ongoing project for specific employee
	public List<Project> selectAllCompletedForSpecificEmp(int empId) {
		List<Project> projectList = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project p  j" + "oin employee e "
					+ "on p.project_id= e.project_id " + "where status ='completed' and emp_id = ?");
			System.out.println(ps + " end");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");
				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("last line on projectdao " + projectList);
		return projectList;
	}

	// get all the project in completed status
	public List<Project> selectAllCompleted() {
		List<Project> projectList = new ArrayList<>();
//						List<Project> newProjectList = new ArrayList<Project>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project where status ='completed'");
			System.out.println(ps + " end");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");
				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("last line on projectdao " + projectList);
		return projectList;
	}

	// get all the project in completed status
	public List<Project> selectAllProjectByName(String s) {
		List<Project> projectList = new ArrayList<>();
//								List<Project> newProjectList = new ArrayList<Project>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project where project_name LIKE ?");
			System.out.println(ps + " end");
			ps.setString(1, "%" + s + "%");
//					     statement.setString(1, "%" + username + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt("project_id");
				String name = rs.getString("project_name");
				String feature = rs.getString("project_feature");
				String status = rs.getString("status");
				projectList.add(new Project(pId, name, feature, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("last line on projectdao " + projectList);
		return projectList;
	}

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
