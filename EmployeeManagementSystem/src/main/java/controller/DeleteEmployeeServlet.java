package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import entity.Employee;

/**
 * Servlet implementation class DeleteProjectServlet
 */
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session==null) {
			response.sendRedirect("index.jsp");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
//		empDao.deleteById(id);
//			List<Employee> projectList = empDao.selectAllEmp();
//			HttpSession session = request.getSession();
//			session.setAttribute("listEmpkeyForjsp", projectList);
//			RequestDispatcher rd = request.getRequestDispatcher("employee-list.jsp");
//			rd.forward(request, response);
//			response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
