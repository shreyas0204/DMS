
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

import com.dexpert.main.databaseconnection.DBConnection;

/**
 * Servlet implementation class updatepartner
 */
@WebServlet("/editbugbyadmin")
public class EditBugByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBugByAdmin() {
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

			ResultSet rs1 = (ResultSet) request.getAttribute("resultSet");
			Random rand = new Random();
			int pick = rand.nextInt(900) + 100;

			// rs1.getInt("pid");
			String pid = request.getParameter("partnerId");
			String partNerType = request.getParameter("partNerType");
			String address = request.getParameter("address");
			String contactNumber = request.getParameter("contactNumber");
			String gender = request.getParameter("gender");
			String occupation = request.getParameter("occupation");
			String email = request.getParameter("email");
			String partnerName = request.getParameter("partnerName");

			Connection con = connection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "UPDATE tendrilla.partners_master SET address = '" + address + "',contactNumber = '"
					+ contactNumber + "',email ='" + email + "',gender = '" + gender + "',occupation = '" + occupation
					+ "',partnerName = '" + partnerName + "' WHERE partnerId = " + pid;

			int i = stmt.executeUpdate(sql);

			RequestDispatcher db = null;

			 System.out.println(i);
				RequestDispatcher rd = null;

				// stmt.executeUpdate();
				if (i!= 0){
					System.out.println("successfully done");
				request.setAttribute("msg", "Record Updated for "+partnerName);
				rd = request.getRequestDispatcher("/success.jsp");
				rd.forward(request, response);
				}else
					System.out.println("unsuccessful");

			

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
