package controller;

import java.io.IOException;

import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import config.DbConnection;
import dao.EmployeeDAO;
import dao.LoginDAO;
import dao.ProjectDAO;
import entity.Employee;
import entity.Project;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDao;
	private ProjectDAO projectDao;
	private EmployeeDAO empDao;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		loginDao = new LoginDAO();
		projectDao = new ProjectDAO();
		empDao = new EmployeeDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//		LoginDAO login = new LoginDAO();
//	}

	static Connection con = DbConnection.getConnection();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session=request.getSession(false);
//		if(session==null) {
//			response.sendRedirect("index.jsp");
//		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String n = request.getParameter("username");
		String p = request.getParameter("userpass");

		try {
			PreparedStatement ps = con.prepareStatement("select * from employee where emp_name= ? and password = ?");
			System.out.println(ps);
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			try {
				int empId = empDao.selectEmployeeIdByName(n);
				if (loginDao.checkPassword(n, p) == true) {
					if (loginDao.checkIsAdmin(empId) == true) {
						if (rs != null) {
							List<Employee> empList = empDao.selectAllEmp();
							System.out.println("size of emp list:" + empList.size());
							session.setAttribute("listEmpkeyForjsp", empList);
							session.setAttribute("adminEmpId", empId);
							RequestDispatcher rd = request.getRequestDispatcher("employee-list.jsp");
							rd.forward(request, response);
						}
					} else if (loginDao.checkIsAdmin(empId) == false) {
						System.out.println(empId);
						session.setAttribute("emp_id", empId);
						RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
						rd.forward(request, response);
					}
				} else {
					out.print("<div class='error-message'>Sorry username or password error.</div>");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		finally {
			out.print("Something went wrong ! ");
		}
	}
}