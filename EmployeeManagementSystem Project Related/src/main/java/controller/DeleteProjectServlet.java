package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDAO;
import entity.Project;

/**
 * Servlet implementation class DeleteProjectServlet
 */
public class DeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		projectDao = new ProjectDAO();
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		try {
			projectDao.deleteById(id);
			List<Project> projectList = projectDao.selectAllProject();
			request.setAttribute("listProjectkeyForjsp", projectList);
			RequestDispatcher rd = request.getRequestDispatcher("project-list.jsp");
			rd.forward(request, response);
//			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
