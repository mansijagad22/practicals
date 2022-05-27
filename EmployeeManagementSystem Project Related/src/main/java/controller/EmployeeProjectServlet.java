package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.ProjectDAO;
import entity.Project;

/**
 * Servlet implementation class EmployeeProjectServlet
 */
public class EmployeeProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDao;
	private ProjectDAO projectDao;
       
	

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
		projectDao = new ProjectDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		int n = (int) httpSession.getAttribute("emp_id");
		System.out.println(n);
		System.out.println(n);
		System.out.println(n);
		PrintWriter out = response.getWriter();
		out.println("hello in EmployeeProjectServlet");
		List<Project> projectList = projectDao.selectAllProject();
		System.out.println("project list : "+projectList);
		System.out.println("sizes : "+projectList.size());
		request.setAttribute("listProjectkeyForjsp", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("employee-specific-project-list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
