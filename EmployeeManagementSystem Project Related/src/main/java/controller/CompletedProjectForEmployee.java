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

import dao.ProjectDAO;
import entity.Project;

/**
 * Servlet implementation class CompletedProjectForEmployee
 */
public class CompletedProjectForEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		projectDao = new ProjectDAO();
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletedProjectForEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
		int empId = (int) httpSession.getAttribute("emp_id");
		
		System.out.println("employee id from ongoing project is : "+empId);
		out.print(" In the Completed Project For Employee");
		List<Project> projectList = projectDao.selectAllCompletedForSpecificEmp(empId);
		
		httpSession.setAttribute("listProjectkeyForupcomingjsp", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("upcoming-project-for-employee.jsp");
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
