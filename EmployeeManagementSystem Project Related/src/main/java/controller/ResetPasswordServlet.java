package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.ApplicationException;

import dao.EmployeeDAO;
import dao.MailService;
import dao.ProjectDAO;
import dto.EmailMessageDTO;
import entity.Employee;
import utility.EmailUtility;
import utility.EmailUtilityFinal;
import utility.ServletUtility;

public class ResetPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
	}
	  public ResetPasswordServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String user;
		PrintWriter out = response.getWriter();
		try {

			user = empDao.findPasswordUsingEmail(email);

			if (user != null) {
				out.print("Your Current Password is :" + user);
			} else {
				out.println("Please provide right associated email address...");
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

//		PrintWriter out = response.getWriter();
//		out.println("hello from reset password servlet ! ");
//		String recipient = request.getParameter("email");
//		String subject = "Your Password has been reset";
//		String message = "";
//
//		try {
//			MailService mailService = new MailService();
//			String newPassword = mailService.resetCustomerPassword(recipient);
//
//			String content = "Hi, this is your new password: " + newPassword;
//			content += "\nNote: for security reason, " + "you must change your password after logging in.";
//
//			EmailUtility.sendEmail(host, port, email, name, pass, recipient, subject, content);
//			message = "Your password has been reset. Please check your e-mail.";
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			message = "There were an error: " + ex.getMessage();
//		}
////		finally {
////			request.setAttribute("message", message);
////			request.getRequestDispatcher("message.jsp").forward(request, response);
////		}
//		RequestDispatcher rd = request.getRequestDispatcher("index.html");
//		rd.forward(request, response);


	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
