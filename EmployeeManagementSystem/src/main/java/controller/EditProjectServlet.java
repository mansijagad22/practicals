//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Date;
//import java.sql.SQLException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import dao.ProjectDAO;
//import entity.Employee;
//import entity.Project;
//
///**
// * Servlet implementation class EditProjectServlet
// */
//public class EditProjectServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private ProjectDAO projectDao;
//
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//		projectDao = new ProjectDAO();
//	}
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public EditProjectServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
////		int id = Integer.parseInt(request.getParameter("project_id"));
////		Project existingProject;
////		try {
////			existingProject = projectDao.selectProjectById(id);
////			RequestDispatcher rd = request.getRequestDispatcher("project-form.jsp");
////			request.setAttribute("projectkeyforjsp", existingProject);
////			rd.forward(request, response);
////		} catch (Exception e) {
////			e.printStackTrace();
//
////		}
//		PrintWriter out = response.getWriter();
//		HttpSession session = request.getSession(true);
//		out.println("hello in edit project servlet");
//		out.println(session.getAttribute("listProjectkeyForjsp"));
//		
//		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.print(id);
//		String name = request.getParameter("name");
//		String feature = request.getParameter("feature");
//		String status = request.getParameter("status");
//
//		Project p = new Project();
//		p.setProjectId(id);
//		p.setProjectName(name);
//		p.setProjectFeature(feature);
//		p.setStatus(status);
//		Boolean m = projectDao.updateProjectDetails(p);
//		out.print(m);
//		System.out.println(p.getProjectId());
//		System.out.println(p.getProjectName());
//		System.out.println(p.getProjectFeature());
//		System.out.println(p.getStatus());
////		if (m == true) {
////			Project project = projectDao.selectProjectById(id);
////			session.setAttribute("listProjectkeyForjsp", project);
////			RequestDispatcher rd = request.getRequestDispatcher("project-list.jsp");
////			rd.forward(request, response);
////		} else {
////			out.print("Details are not update");
////		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
