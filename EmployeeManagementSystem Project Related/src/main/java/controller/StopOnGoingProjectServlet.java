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
 * Servlet implementation class StopOnGoingProjectServlet
 */
public class StopOnGoingProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProjectDAO projectDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		projectDao = new ProjectDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StopOnGoingProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Boolean m = projectDao.updateProjectStatusToComplete(id);
		out.println(id);
		if(m==true) {
		List<Project> projectList = projectDao.selectAllOngoing();	
		httpSession.setAttribute("listProjectkeyForongoingjsp", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("ongoing-project.jsp");
		rd.forward(request, response);
		}
		else {
			out.print("Not update");
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
