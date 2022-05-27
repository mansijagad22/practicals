package mysqlConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static String dbhost = "jdbc:mysql://localhost:3306/empdb";
	private static String username = "root";
	private static String password = "Mansi@321";
	private static Connection conn;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("username");
		String passw = request.getParameter("userpass");
		
		

		try {
			conn = DriverManager.getConnection(
					dbhost, username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try {
				
			if(conn!=null) {
				PreparedStatement ps = conn.prepareStatement("select * from employee where emp_name = ? and password = s");
////			ps = conn.prepareStatement(password)
				ps.setString(1, uname);
				ps.setString(2, passw);
				ResultSet rs = ps.executeQuery();
//				status = rs.next();
//				System.out.print(rs);
				RequestDispatcher rd = request.getRequestDispatcher("MainPageServlet");
				rd.forward(request, response);
			}
			else {
				out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		        rd.include(request,response);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
