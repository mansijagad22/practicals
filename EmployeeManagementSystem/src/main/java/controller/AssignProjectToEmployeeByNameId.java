package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.ProjectDAO;

/**
 * Servlet implementation class AssignProjectToEmployeeByNameId
 */
public class AssignProjectToEmployeeByNameId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProjectDAO projectDao;
	private EmployeeDAO empDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		projectDao = new ProjectDAO();
		empDao = new EmployeeDAO();
	}
    public AssignProjectToEmployeeByNameId() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession(true);
		int projectId =  (int)(httpSession.getAttribute("project_id"));
		out.println("project is :"+projectId);
		String empName = request.getParameter("employee_name");
		out.println("employee name : "+empName);
		int empId = empDao.selectEmployeeIdByName(empName);
		out.println("empID is :"+empId);
		 boolean m = empDao.updateEmpProjectIdDetail(empId,projectId );
		 boolean n = projectDao.updateProjectStatusToOngoing(projectId);
		 
		 if(m==true && n==true) {
			 RequestDispatcher rd = request.getRequestDispatcher("AllProjectListServlet");
				rd.forward(request, response);
		 }
		 else {
			 out.println("Project is Not Assign to employee !!");
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
