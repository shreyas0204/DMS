
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dexpert.main.databaseconnection.DBConnection;
import com.tendrilla.mail.MailSender;

/**
 * Servlet implementation class edit
 */
@WebServlet("/editclient")
public class editclient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editclient() {
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
		System.out.println("inside doget");

		try {
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); Connection con =
			 * (Connection) DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/tendrilla", "root", "");
			 */

			// Statement connection=null;
			Connection con = connection.getConnection();
			Statement stmt = con.createStatement();
			RequestDispatcher db = null;
			HttpSession session = request.getSession();

			stmt = con.createStatement();

			int a = Integer.parseInt(request.getParameter("id"));
			System.out.println("print organizationid=" + a);

			Statement statement = (Statement) con.createStatement();
			String sql = "select * from defect_info where id=" + a;
			ResultSet rs1 = statement.executeQuery(sql);
			RequestDispatcher rd = null;
			
			    System.out.println("I am Inside Loop");
				request.setAttribute("resultSet", rs1);
				System.out.println("afetr request");
				rd = request.getRequestDispatcher("/editclient.jsp");
				rd.forward(request, response); 
			

		}

		catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

}
