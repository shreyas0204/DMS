
import java.sql.*;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.env.ISourceMethod;

import com.dexpert.main.databaseconnection.DBConnection;
import com.tendrilla.mail.MailSender;


/**
 * Servlet implementation class addpartner
 */
@WebServlet("/addpartner")
public class addpartner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addpartner() {
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
			/*Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tendrilla", "root",
					"");*/
			Connection con=connection.getConnection();
			Statement stmt = con.createStatement();
			RequestDispatcher db = null;
			HttpSession session = request.getSession();
			// String partnerID = (String) session.getAttribute("PARTNERID");
			String partNerType = request.getParameter("partNerType");
			String address = request.getParameter("address");
			// String reffer_Partner_Idfk
			// =request.getParameter("reffer_Partner_Idfk");
			// System.out.println("partner id from session converted to int
			// is::"+Integer.parseInt(partnerID));
			String contactNumber = request.getParameter("contactNumber");
			String gender = request.getParameter("gender");
			String occupation = request.getParameter("occupation");
			String email = request.getParameter("email_address");
			String registeredDate = request.getParameter("registeredDate");
			String partnerName = request.getParameter("partnerName");
			Random rand = new Random();
			int pick = rand.nextInt(900) + 100;
			stmt = con.createStatement();
			

			String sql = "insert into tendrilla.partners_master(partnerId, address, contactNumber, email, gender, occupation,"
					+ " parentPartNerId,partNerType, partnerName, registeredDate, loginBean_loginId)" + "Values(null,'"
					+ address + "','" + contactNumber + "','" + email + "','" + gender + "','" + occupation + "'," + "'"
					+ pick + "','" + partNerType + "','" + partnerName + "',current_timestamp(),null)";

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			System.out.println("Print id is =" + id);
			String username = partnerName.toUpperCase().substring(0, 4).trim() + "_" + id;
			passwardgenerator pg = new passwardgenerator();
			String passward = String.valueOf(pg.generatePswd(10));
			// System.out.println("Print id is ="+username);
			// System.out.println("Print id is ="+pg);

			String sql2 = "insert into tendrilla.login_master(loginId,password,userName,partner_Id_Fk,user_id_fk,org_type)"
					+ "" + "values('"+pick+"','" + pg + "','" + username + "',"+id+",null,'client')";
			
			stmt.executeUpdate(sql2);
			MailSender mail = new MailSender();
			if (!email.isEmpty() || email != null || !email.equals("")) {
				mail.send(email, username, passward, partnerName);
			}

			/*
			 * int i=sql.executeUpdate(); if(i==0) {
			 * db=request.getRequestDispatcher("/successful_login.jsp");
			 * db.forward(request, response); } else {
			 * db=request.getRequestDispatcher("/successful_login.jsp");
			 * db.forward(request, response); }
			 */

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
