package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import entity.Address;
import entity.Employee;

/**
 * Servlet implementation class EditEmployeeByAdminServlet
 */
public class EditEmployeeByAdminServlet extends HttpServlet {
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
    public EditEmployeeByAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		if(session==null) {
			response.sendRedirect("index.jsp");
		}
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("emp_id"));
		System.out.println("In the homepage servlet empId i get is : " + id);

		try {
			Employee emp = empDao.getEmpDetailById(id);
			List<Address> add = addDao.selectAddDetailsByEmpId(id);
			int len = add.size();
			ArrayList<String> street = addDao.selectStreetDetailByEmpId(id);
			ArrayList<String> city = addDao.selectCityDetailByEmpId(id);
			ArrayList<String> state = addDao.selectStateDetailByEmpId(id);
			ArrayList<String> pinCode = addDao.selectPinCodeDetailByEmpId(id);
			for(int i=0;i<len;i++){
				System.out.println("street value for "+i+" index is: " +street.get(i));			}
			String streetarray = new String(), cityarray, statearray, pincodearray;
			request.setAttribute("empKeyForjsp", emp);
			HttpSession httpSession = request.getSession();
			int adminEmpId = (int) httpSession.getAttribute("adminEmpId");
			httpSession.setAttribute("adminEmpId", adminEmpId);
			httpSession.setAttribute("empKeyForjsp", emp);
			httpSession.setAttribute("street", street);
			httpSession.setAttribute("city", city);
			httpSession.setAttribute("state", state);
			httpSession.setAttribute("pinCode", pinCode);
			httpSession.setAttribute("addressDetailsKeyForJsp", add);
			httpSession.setAttribute("emp_id", id);
			RequestDispatcher rd = request.getRequestDispatcher("edit-employee-details.jsp");
			rd.forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		String n = (String) request.getAttribute("username");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
