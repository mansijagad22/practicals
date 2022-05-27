package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		String driver = config.getInitParameter("driver");
		out.print("Driver is : "  + driver);
		
		
		Enumeration<String> en = config.getInitParameterNames();
		String s = "";
		while(en.hasMoreElements()) {
			s = en.nextElement();
			out.print("name : "+ s);
			out.print("value : "+ config.getInitParameter(s));
		}
		
		out.close();
		
		
	}
	
}
