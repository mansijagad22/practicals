package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(urlPatterns = "/invalidate-session")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub// in your logout.jsp page %>
		HttpSession session = request.getSession(false);
//		session.setAttribute("listEmpkeyForjsp", null);
//		session.setAttribute("emp_id", null);
//		response.setHeader("Cache-Control", "no-cache");
//		response.setHeader("Cache-Control", "no-store");
//		response.setHeader("Pragma", "no-cache");
//		response.setDateHeader("Expires", 0);
//		if (session.getAttribute("listEmpkeyForjsp") == null || session.getAttribute("emp_id") == null) {

//		}
//		session.invalidate();
//		response.sendRedirect("index.html");  
//		response.getWriter().println("Session : " + session);
//		request.getSession(false);
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

}
