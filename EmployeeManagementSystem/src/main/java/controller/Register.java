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

import dao.AddressDAO;
import dao.EmployeeDAO;
import dao.ProjectDAO;
import dao.SaveDAO;
import entity.Address;
import entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Base64;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDao = new EmployeeDAO();
	private AddressDAO addDao = new AddressDAO();
	private SaveDAO saveDao = new SaveDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session==null) {
			response.sendRedirect("index.jsp");
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean checkUserExist = false;

		// get values from payload for employee
		String name = request.getParameter("name");
		String mobNo = request.getParameter("mob");
		String dob = request.getParameter("dob");
		String hobbies = request.getParameter("hobbies");
		String isAdmin = request.getParameter("fav_language");
		String email = request.getParameter("email");
		String projectId = request.getParameter("projectid");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		// get values for addresses
		int count;
		for (count = 0; count < 10; count++) {
			String street = request.getParameter("test[" + count + "][street]");
			String city = request.getParameter("test[" + count + "][city]");
			String state = request.getParameter("test[" + count + "][state]");
			String pinCode = request.getParameter("test[" + count + "][pinCode]");
			System.out.println("value of index is: " + count);
			if (street == null && city ==null && state==null && pinCode==null) 
				break;
		}
		System.out.println("count of city are: " + count);
		// Encoding string
		Base64.Encoder encoder = Base64.getEncoder();
		String encodePassword = encoder.encodeToString(password.getBytes());

		// set values in employee object and save
		Employee e = new Employee();
		e.setEmpName(name);
		e.setMobNo(mobNo);
		e.setDob(Date.valueOf(dob));
		e.setHobbies(hobbies);
		e.setIsAdmin(Integer.parseInt(isAdmin));
		e.setEmail(email);
		e.setProjectId(Integer.parseInt(projectId));
		e.setPassword(encodePassword);
		if (password.equals(confirmPassword)) {
			int status = saveDao.saveEmployee(e);
			int empId = empDao.selectLatestEmpId();
		

		int statusAddress = 0;
		// get addresses and save
		for (int j = 0; j < count; j++) {
			String street = request.getParameter("test[" + j + "][street]");
			String city = request.getParameter("test[" + j + "][city]");
			String state = request.getParameter("test[" + j + "][state]");
			String pin = request.getParameter("test[" + j + "][pincode]");

			System.out.println("entered street:" + street);
			System.out.println("entered city:" + city);
			System.out.println("entered state: " + state);
			System.out.println("entered pin :" + pin);
			System.out.println();
			System.out.println();

			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setPinCode(pin);
			address.setEmpId(empId);
			statusAddress = addDao.insertNewAddress(address);
		}
		if (status > 0 && statusAddress > 0) {
			out.print("<p>Record saved successfully!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		} else {
			out.println("Sorry! unable to save record");
		}
		}
		else {
			out.print("<div class='error-message'> Please enter same password </div>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
//		} else {
//			out.println("User name already exists, please choose another name");
//		}

	}
	}
}
