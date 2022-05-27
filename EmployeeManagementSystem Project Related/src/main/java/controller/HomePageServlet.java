package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import config.DbConnection;
import dao.AddressDAO;
import dao.EmployeeDAO;
import dao.LoginDAO;
import dao.ProjectDAO;
import dao.SaveDAO;
import entity.Address;
import entity.Employee;
import entity.Project;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet()
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = DbConnection.getConnection();
	private LoginDAO loginDao;
	private EmployeeDAO empDao;
	private AddressDAO addDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		loginDao = new LoginDAO();
		empDao = new EmployeeDAO();
		addDao = new AddressDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		int n1 = (int) session.getAttribute("emp_id");
		System.out.println("In the homepage servlet empId i get is : " + n1);

		try {
			Employee emp = empDao.getEmpDetailById(n1);
			List<Address> add = addDao.selectAddDetailsByEmpId(n1);
			int len = add.size();
			ArrayList<String> street = addDao.selectStreetDetailByEmpId(n1);
			ArrayList<String> city = addDao.selectCityDetailByEmpId(n1);
			ArrayList<String> state = addDao.selectStateDetailByEmpId(n1);
			ArrayList<String> pinCode = addDao.selectPinCodeDetailByEmpId(n1);
			for(int i=0;i<len;i++){
				System.out.println("street value for "+i+" index is: " +street.get(i));			}
			String streetarray = new String(), cityarray, statearray, pincodearray;
//			for (int i = 0; i < len; i++) {
//				
//				streetarray = streetarray.coadd.get(i).getStreet();
//				System.out.println(streetarray + " at " + i);
//			}
//			for (int i = 0; i < len; i++) {
//				cityarray = add.get(i).getCity();
//				System.out.println(cityarray + " at " + i);
//			}
//			for (int i = 0; i < len; i++) {
//				statearray = add.get(i).getState();
//				System.out.println(statearray + " at " + i);
//			}
//			for (int i = 0; i < len; i++) {
//				pincodearray = add.get(i).getPinCode();
//				System.out.println(pincodearray + " at " + i);
//			}
//			System.out.println("array of street: "+streetarray);
			request.setAttribute("empKeyForjsp", emp);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("empKeyForjsp", emp);
			httpSession.setAttribute("street", street);
			httpSession.setAttribute("city", city);
			httpSession.setAttribute("state", state);
			httpSession.setAttribute("pinCode", pinCode);
			httpSession.setAttribute("addressDetailsKeyForJsp", add);
			httpSession.setAttribute("emp_id", n1);
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		String n = (String) request.getAttribute("username");

	}
}