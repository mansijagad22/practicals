package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDAO;
import dao.EmployeeDAO;
import dao.LoginDAO;
import dao.SaveDAO;
import entity.Address;
import entity.Employee;

/**
 * Servlet implementation class ProfileServletForEditEmp
 */
public class ProfileServletForAddEmpAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDAO empDao;
	private AddressDAO addressDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
		addressDao = new AddressDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServletForAddEmpAddress() {
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
		PrintWriter out = response.getWriter();
		
		out.print("hello from save address ");
		HttpSession session = request.getSession(true);
		out.println("hello in profile servlet");
		out.println(session.getAttribute("empKeyForjsp"));
		int id = (int) session.getAttribute("emp_id");
		out.print(id);
		System.out.print(id);
//
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pinCode = request.getParameter("pincode");

		Address adr = new Address();
		adr.setStreet(street);
		out.print(street);
		System.out.print(street);
		
		adr.setCity(city);
		out.print(city);
		System.out.print(city);
		
		adr.setState(state);
		out.print(state);
		System.out.print(state);
		
		adr.setPinCode(pinCode);
		out.print(pinCode);
		System.out.print(pinCode);
		
		adr.setEmpId(id);
		int status = addressDao.insertNewAddress(adr);
		if(status>0) {
			out.print("<p>Record saved successfully!</p>");
        	RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
        	rd.forward(request, response);	
        	LoginServlet ls = new LoginServlet();
        	ls.doPost(request, response);
		}
		else {
		
		
			out.print("address is not inserted ");
//			Employee emp;
//			try {
//				emp = empDao.getEmpDetailById(id);
//				out.println(emp.getEmpId());
//				out.println(emp.getEmail());
//				out.println(emp.getEmpName());
//				session.setAttribute("empKeyForjsp", emp);
//				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
//				rd.forward(request, response);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
		}
	}

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
