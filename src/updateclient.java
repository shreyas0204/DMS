
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
@WebServlet("/updateclient")
public class updateclient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateclient() {
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

			String organizationId = request.getParameter("organizationId");
			String organization_name = request.getParameter("organization_name");
			String relationship_type = request.getParameter("relationship_type");
			String reffer_Partner_Idfk = request.getParameter("reffer_Partner_Idfk");
			String Name = request.getParameter("Name");
			String Address = request.getParameter("Address");

			Connection con = connection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "UPDATE tendrilla.organization_master SET organization_name = '" + organization_name + "',relationship_type = '"
					+ relationship_type + "',reffer_Partner_Idfk ='" + reffer_Partner_Idfk + "',Name = '" + Name + "',Address = '" + Address
					+ "',WHERE organizationId = " + organizationId;

			int i = stmt.executeUpdate(sql);

			RequestDispatcher db = null;

			 System.out.println(i);
				RequestDispatcher rd = null;

				// stmt.executeUpdate();
				if (i!= 0){
					System.out.println("successfully done");
				request.setAttribute("msg", "Record Updated for "+Name);
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
