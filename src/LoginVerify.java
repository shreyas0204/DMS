import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dexpert.main.databaseconnection.DBConnection;
import com.main.constants.ProjectConstants;


/**
 * Servlet implementation class LoginVerify
 */
@WebServlet("/LoginVerify")
public class LoginVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginVerify() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 DBConnection connection = new DBConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		try {
						Connection con=connection.getConnection();
			Statement statement = (Statement) con.createStatement();
			String email = request.getParameter("email");
			//System.out.println("username received form the rtequest is:" + username);
			String password = request.getParameter("pass");
			System.out.println("password received form the rtequest is:" + password);
			ResultSet rs = statement.executeQuery(
					"select * from login_master where email = '" + email + "'and password='" + password + "'");
			RequestDispatcher rd = null;
			HttpSession session = request.getSession();

			if (rs.next()) {
				String usertype = rs.getString("user_type");
				//String paerner = rs.getString("partner_Id_Fk");
				Integer id=rs.getInt("id");
				session.setAttribute("sessionID", id);
				if (usertype.equalsIgnoreCase(ProjectConstants.ADMIN)) {

					// System.out.println("partner login case");
					rd = request.getRequestDispatcher("/admin.jsp");

					session.setAttribute("UserProfile", usertype);

					rd.forward(request, response);
				}
				if (usertype.equalsIgnoreCase(ProjectConstants.TESTER)) {

					
					rd = request.getRequestDispatcher("/tester-home.jsp");

					
					rd.forward(request, response);
				}

			} else {

				rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("error", "Invalid Username or Password");
				rd.forward(request, response);
			}
		}

		catch (Exception e) {
			System.out.println(e);
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
	// public ResultSet getClient()
	// {

	// return
	// }

}
