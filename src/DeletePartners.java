
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dexpert.main.databaseconnection.DBConnection;

/**
 * Servlet implementation class DeletePartners
 */
@WebServlet("/DeletePartners")
public class DeletePartners extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBConnection connection = new DBConnection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePartners() {
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
		String partner_id = request.getParameter("id");
		System.out.println("Partner Id is " + partner_id);

		try {
			Connection con = connection.getConnection();
			Statement stmt = con.createStatement();
			String sqldel = "Delete FROM tendrilla.partners_master Where partnerId=" + partner_id.trim();
			stmt.executeUpdate(sqldel);

			String msg =" Partner " + partner_id + " has been deleted.";
			System.out.println(msg);
			RequestDispatcher rd = null;
			request.setAttribute("msg", msg);
			rd = request.getRequestDispatcher("/fetchpartners");
			rd.forward(request, response);

		} catch (SQLException e) {
			System.out.println("Expense isn't deleting - SQLException");
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
