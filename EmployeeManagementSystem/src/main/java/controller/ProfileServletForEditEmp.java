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

import org.apache.taglibs.standard.tag.common.sql.DataSourceWrapper;

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
	private LoginDAO loginDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDAO();
		addDao = new AddressDAO();
		loginDao = new LoginDAO();
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
		HttpSession session1 = request.getSession();
		if(session1==null) {
			response.sendRedirect("index.jsp");
		}
		DataSourceWrapper dt = new DataSourceWrapper();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		out.println("hello in profile servlet");
		
	
		int id = (int) session.getAttribute("emp_id");
		Boolean updateAddress = false;
		@SuppressWarnings("unchecked")
		List<Address> add = (List<Address>) session.getAttribute("addressDetailsKeyForJsp");
		int n = add.size();
		int statusAddress = 0;
		if (n == 0) {
			for (int j = 0; j < 10; j++) {
				String street = request.getParameter("street[" + j + "]");
				String city = request.getParameter("city[" + j + "]");
				String state = request.getParameter("state[" + j + "]");
				String pinCode = request.getParameter("pinCode[" + j + "]");
				if (street == null && city == null && state == null && pinCode == null)
					break;
				Address address = new Address();
				address.setStreet(street);
				address.setCity(city);
				address.setState(state);
				address.setPinCode(pinCode);
				address.setEmpId(id);
				statusAddress = addDao.insertNewAddress(address);
			}
		}
		if (statusAddress > 0) {
			toRediretMainPages(request,response);
		}
		System.out.println("size of address is : " + n);
		int count;
		for (count = 0; count < n; count++) {
			String street = request.getParameter("street[" + count + "]");
			String city = request.getParameter("city[" + count + "]");
			String state = request.getParameter("state[" + count + "]");
			String pinCode = request.getParameter("pinCode[" + count + "]");
			if (street == null && city == null && state == null && pinCode == null) {
				add.get(count).getAddId();
				addDao.deleteById(add.get(count).getAddId());
				System.out.println("Address id deleted: " + add.get(count).getAddId());
				continue;
			}
			Address a = new Address();
			int addId = add.get(count).getAddId();
			int updatestatus=0;
			for (int i = count; i < n; i++) {
				if (i == count)
					continue;
				System.out.println(" i " + i);
				System.out.println(" count " + count);
				System.out.println("comparing values of both street at " + i + " and " + count + "  is "
						+ add.get(i).getStreet() + " " + street);
				if (add.get(i).getStreet().equals(street) && add.get(i).getCity().equals(city)
						&& add.get(i).getState().equals(state) && add.get(i).getPinCode().equals(pinCode)) {
					System.out.println("compare street name at i = " + i + "and count = " + count);
					System.out.println();
					updateAddress = false;
//					out.print("<div class='error-message'>Sorry username or password error.</div>");
					out.println("<div class='error-message'> Can not update any fields as addresses are same !! </div>");
					toRediretMainPages(request,response);	
					break;
				} else {
					System.out.println("address id for update address " + addId);
					a.setStreet(street);
					a.setCity(city);
					a.setState(state);
					a.setPinCode(pinCode);
					a.setAddId(addId);
					a.setEmpId(id);
					updateAddress = addDao.updateAddressByAddIdAndEmpId(a);
					System.out.println("value of index is: " + count);
				}
			}

		}
//		Address a  = new Address();
//		if(add.size()>0) {
//			int addressId = add.get(0).getAddId();
//			a.setAddId(addressId);
//			a.setEmpId(id);
//			a.setCity(city);
//			updateAddress = addDao.updateAddressByAddIdAndEmpId(a);
//		}
		int m = 0;
		System.out.println("start value for m is: " + m);
		int statusAddress1 = 0;
		while (request.getParameter("test[" + m + "][street]") != null) {
			String street = request.getParameter("test[" + m + "][street]");
			String city = request.getParameter("test[" + m + "][city]");
			String state = request.getParameter("test[" + m + "][state]");
			String pinCode = request.getParameter("test[" + m + "][pincode]");
			
			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setPinCode(pinCode);
			address.setEmpId(id);
			statusAddress1 = addDao.insertNewAddress(address);
			System.out.println("value of street address as test " + m + " index is " + street);
			m++;
		}
		System.out.println("end value for m is: " + m);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobNo = request.getParameter("mob");
		String dob = request.getParameter("dob");
		String hobbies = request.getParameter("hobbies");
		String isAdmin = request.getParameter("fav_language");
		String password = request.getParameter("password");
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
		int b = empDao.updateEmpDetails(e);
		out.print(b);
		if (b > 0 && updateAddress == true) {
			// Employee emp = empDao.getEmpDetailById(id);
			// session.setAttribute("empKeyForjsp", emp);
			List<Employee> empList = empDao.selectAllEmp();
			session.setAttribute("listEmpkeyForjsp", empList);
			RequestDispatcher rd = request.getRequestDispatcher("employee-list.jsp");
			rd.forward(request, response);
		} else {
			out.println("Details are not update");
		}
	}
	private void toRediretMainPages(HttpServletRequest request, HttpServletResponse response) {
		try {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		int adminEmpId = (int) session.getAttribute("adminEmpId");
		int id = (int) session.getAttribute("emp_id");
		out.println(adminEmpId);
		out.println(adminEmpId);
		out.println(adminEmpId);
		if (loginDao.checkIsAdmin(adminEmpId) == true) {
				out.print("<p>Record saved successfully!</p>");
				List<Employee> empList = empDao.selectAllEmp();
				System.out.println("size of emp list:" + empList.size());
				session.setAttribute("listEmpkeyForjsp", empList);
				RequestDispatcher rd = request.getRequestDispatcher("employee-list.jsp");
				rd.forward(request, response);
			} else if (loginDao.checkIsAdmin(adminEmpId) == false) {
				System.out.println(id);
				session.setAttribute("emp_id", id);
				RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);
			} else {
				out.print("<div class='error-message'>Sorry username or password error.</div>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
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
//	ArrayList<String> street = addDao.selectStreetDetailByEmpId(id);
//	ArrayList<String> city = addDao.selectCityDetailByEmpId(id);
//	ArrayList<String> state = addDao.selectStateDetailByEmpId(id);
//	ArrayList<String> pinCode = addDao.selectPinCodeDetailByEmpId(id);
//	for(int i=0;i<n;i++){
//		System.out.println("street value for "+i+" index is: " +street.get(i));			
//
//
//	System.out.println("adress values street:"+ street.get(i));
//	System.out.println("adress values city:"+ city.get(i));
//	System.out.println("adress values state:"+ state.get(i));
//	System.out.println("adress values pincode:"+ pinCode.get(i));
//	

//	a.setStreet(street.get(i));
//	a.setCity(city.get(i));
//	a.setState(state.get(i));
//	a.setPinCode(pinCode.get(i));

//	for (int j = 0; j < m; j++) {
//		String street = request.getParameter("test[" + j + "][street]");
//		String city = request.getParameter("test[" + j + "][city]");
//		String state = request.getParameter("test[" + j + "][state]");
//		String pin = request.getParameter("test[" + j + "][pincode]");
//
//		System.out.println("entered street:" + street);
//		System.out.println("entered city:" + city);
//		System.out.println("entered state: " + state);
//		System.out.println("entered pin :" + pin);
//		System.out.println();
//		System.out.println();
//
//		
//	}

}
