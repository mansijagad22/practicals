package controller;

import java.io.IOException;
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
 * Servlet implementation class UpcomingProjectServlet
 */
public class UpcomingProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		projectDao = new ProjectDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpcomingProjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Project> projectList = projectDao.selectAllUpcoming();
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("listProjectkeyForupcomingjsp", projectList);
			RequestDispatcher rd = request.getRequestDispatcher("upcoming-project.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}	}

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
