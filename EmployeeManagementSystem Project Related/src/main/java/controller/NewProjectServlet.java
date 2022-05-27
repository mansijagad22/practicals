package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.LoginDAO;
import dao.ProjectDAO;
import dao.SaveDAO;
import entity.Employee;
import entity.Project;

/**
 * Servlet implementation class NewProjectServlet
 */
public class NewProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		projectDao = new ProjectDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewProjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Project p = new Project();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
	    String name=request.getParameter("name");  
        String feature=request.getParameter("feature");
          
        p.setProjectName(name);
        p.setProjectFeature(feature);
 
		projectDao.insertProjectNew(p);
		List<Project> projectList = projectDao.selectAllProject();
		request.setAttribute("listProjectkeyForjsp", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("project-list.jsp");
		rd.forward(request, response);
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
