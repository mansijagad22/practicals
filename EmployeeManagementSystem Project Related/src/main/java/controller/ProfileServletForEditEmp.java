package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
public class ProfileServletForEditEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDAO empDao;
	private AddressDAO addDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
		addDao = new AddressDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServletForEditEmp() {
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
		HttpSession session = request.getSession(true);
		out.println("hello in profile servlet");
		out.println(session.getAttribute("empKeyForjsp"));
		int id = (int) session.getAttribute("emp_id");
		Boolean updateAddress=false;
		@SuppressWarnings("unchecked")
		List<Address> add = (List<Address>) session.getAttribute("addressDetailsKeyForJsp");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobNo = request.getParameter("mob");
		String dob = request.getParameter("dob");
		String hobbies = request.getParameter("hobbies");
		String isAdmin = request.getParameter("fav_language");
		String password = request.getParameter("password");
		int n =add.size();
		System.out.println("size of address is : "+n);
		int count;
		for (count = 0; count < n; count++) {
			String city = request.getParameter("test[" + count + "]");
			System.out.println("city is :" + city);
			System.out.println("value of index is: " + count);
			if (city == null)
				break;
		}
		String[] street1 = request.getParameterValues("street");
		System.out.println("Street value from edit-employee-details : "+street1);
//		ArrayList<String> street = addDao.selectStreetDetailByEmpId(id);
//		ArrayList<String> city = addDao.selectCityDetailByEmpId(id);
//		ArrayList<String> state = addDao.selectStateDetailByEmpId(id);
//		ArrayList<String> pinCode = addDao.selectPinCodeDetailByEmpId(id);
//		for(int i=0;i<n;i++){
//			System.out.println("street value for "+i+" index is: " +street.get(i));			
//
//	
//		System.out.println("adress values street:"+ street.get(i));
//		System.out.println("adress values city:"+ city.get(i));
//		System.out.println("adress values state:"+ state.get(i));
//		System.out.println("adress values pincode:"+ pinCode.get(i));
//		
		Address a  = new Address();
//		a.setStreet(street.get(i));
//		a.setCity(city.get(i));
//		a.setState(state.get(i));
//		a.setPinCode(pinCode.get(i));
		int addressId = add.get(0).getAddId();
		a.setAddId(addressId);
		a.setEmpId(id);
		updateAddress = addDao.updateAddressByAddIdAndEmpId(a);
		
	
		Employee e = new Employee();
		e.setEmpId(id);
		e.setEmpName(name);
		e.setEmail(email);
		e.setMobNo(mobNo);
		e.setDob(Date.valueOf(dob));
		e.setHobbies(hobbies);
		e.setIsAdmin(Integer.parseInt(isAdmin));
		Base64.Encoder encoder = Base64.getEncoder();
		String encodePassword = encoder.encodeToString(password.getBytes());
		e.setPassword(encodePassword);
		Boolean m = empDao.updateEmpDetails(e);
		out.print(m);
		if (m == true && updateAddress==true) {
			try {
				Employee emp = empDao.getEmpDetailById(id);
				session.setAttribute("empKeyForjsp", emp);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			out.print("Details are not update");
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
