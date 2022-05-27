package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.ProjectDAO;
import entity.Employee;
import entity.Project;

/**
 * Servlet implementation class ProjectServlet
 */
public class EmployeeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			String name = (String) request.getParameter("name");
			List<Employee> empList = empDao.selectAllEmpByName(name);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("search", empList);
			if (empList.size() > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("search-result.jsp");
				rd.forward(request, response);
			} else {
				out.print("No Data Found");
			}
//			List<Employee> empList = empDao.selectAllEmp();
//			System.out.println("project list : " + empList);
//			System.out.println("sizes : " + empList.size());
//			request.setAttribute("listEmpkeyForjsp", empList);
//			RequestDispatcher rd = request.getRequestDispatcher("employee-list.jsp");
//			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
