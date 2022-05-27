package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDAO;


/**
 * Servlet implementation class DeleteProjectServlet
 */
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressDAO addDao;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		addDao = new AddressDAO();
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		int empId = Integer.parseInt(request.getParameter("emp_id"));
		try {
			addDao.deleteById(id);
			RequestDispatcher rd = request.getRequestDispatcher("EditEmployeeByAdminServlet");
			rd.include(request, response);
//			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
