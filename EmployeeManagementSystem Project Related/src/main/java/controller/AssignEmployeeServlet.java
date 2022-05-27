package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class AssignEmployeeServlet
 */
public class AssignEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDao;
	private EmployeeDAO empDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		projectDao = new ProjectDAO();
		empDao = new EmployeeDAO();
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String empName = request.getParameter("employee_name");
		List<Employee> empList = new ArrayList<Employee>();
		Project p =projectDao.selectProjectById(id);
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("project_id", id);
		httpSession.setAttribute("projectInfo", p);
		out.print(p.getProjectId());
		out.println(p.getProjectName());
		empList = empDao.selectAllEmployeeNameAndId();
//		out.println(empList.get(id));
		httpSession.setAttribute("empList", empList);
		RequestDispatcher rd = request.getRequestDispatcher("assign-project-to-employee.jsp");
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
