
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
@WebServlet("/NewBugByAdmin")
public class NewBugByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewBugByAdmin() {
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
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String bug_type = request.getParameter("type");
			String severity = request.getParameter("severity");
			String status = request.getParameter("status");
			String description = request.getParameter("description");
			LocalDateTime date = LocalDateTime.now();
			System.out.println(id);
			System.out.println(name);
			System.out.println(bug_type);
			System.out.println(date);
			
			Random rand = new Random();
			int pick = rand.nextInt(900) + 100;
			stmt = con.createStatement();
			

			String sql = "insert into dms.defect_info(name,bug_type,severity, status,description,tester_id,date) Values('"	+ name + "','" + bug_type + "','" + severity + "','" + status + "','" + description + "','"+ id + "','" + date + "')";

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			int ids = rs.getInt(1);
			System.out.println("Print id is =" + id);
			

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
