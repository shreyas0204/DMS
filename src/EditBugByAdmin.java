
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
@WebServlet("/EditBugByAdmin")
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

			ResultSet rs1 = (ResultSet) request.getAttribute("id");
			Random rand = new Random();
			int pick = rand.nextInt(900) + 100;

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String bug_type = request.getParameter("bug_type");
			String severity = request.getParameter("severity");
			String status = request.getParameter("status");
			String description = request.getParameter("description");

			Connection con = connection.getConnection();
			Statement stmt = con.createStatement();
			String sql = "UPDATE dms.defect_info SET name = '" + name + "',bug_type = '" + bug_type + "',severity ='"
					+ severity + "',status = '" + status + "',description = '" + description + "' WHERE id = " + id;

			int i = stmt.executeUpdate(sql);

			RequestDispatcher db = null;

			System.out.println(i);
			RequestDispatcher rd = null;

			// stmt.executeUpdate();
			if (i != 0) {

				rd = request.getRequestDispatcher("/success.jsp");
				rd.forward(request, response);
			} else
				;

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
