package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SaveDAO;
import entity.Employee;

/**
 * Servlet implementation class EditEmployeeDetails
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		request.setAttribute("emp, out);
		out.print("Hello in Edit Employee Details"); 
		out.print(request.getAttribute("empKeyForjsp"));
		HttpSession httpSession = request.getSession();
		httpSession.getAttribute("empKeyForjsp");
//		out.print(httpSession.getAttribute("empKeyForjsp"));
//		request.setAttribute("empdetail", emp);
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
    	rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//	
//	    String name=request.getParameter("name");  
//        String mobNo=request.getParameter("mob");  
//        String dob=request.getParameter("dob");
//        String address1=request.getParameter("address1");  
//        String address2=request.getParameter("address2");  
//        String hobbies=request.getParameter("hobbies"); 
//        String isAdmin = request.getParameter("fav_language");
//        String email=request.getParameter("email"); 
//        String projectId=request.getParameter("projectid");
//        String password=request.getParameter("password");  
//          
//        Employee e=new Employee();  
//        e.setEmpName(name);  
//        e.setMobNo(mobNo);  
//        e.setDob(Date.valueOf(dob));  
//        e.setAddress1(address1); 
//        e.setAddress2(address2);
//        e.setHobbies(hobbies);
//        e.setIsAdmin(Integer.parseInt(isAdmin));
//        e.setEmail(email);  
//        e.setProjectId(Integer.parseInt(projectId));
//        e.setPassword(password);  
//		 
//        int status = SaveDAO.saveEmployee(e);
//        
//        if(status>0) {
//        	out.println("<p>Record saved successfully!</p>");
//        	RequestDispatcher rd = request.getRequestDispatcher("index.html");
//        	rd.forward(request, response);	
//        	LoginServlet ls = new LoginServlet();
//        	ls.doPost(request, response);
//        }
//        else {
//            out.println("Sorry! unable to save record");
//        }
//		
	}
	}

