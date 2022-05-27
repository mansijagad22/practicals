package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.LoginDAO;
import dao.ProjectDAO;
import entity.Employee;
import entity.Project;

/**
 * Servlet implementation class AllProjectListServlet
 */
public class AllEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployeeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employee> empList = empDao.selectAllEmp();
		System.out.println("size of project list:" + empList.size());
		request.setAttribute("listEmpkeyForjsp", empList);
		RequestDispatcher rd = request.getRequestDispatcher("project-list.jsp");
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
