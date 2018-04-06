

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class viewclient
 */
@WebServlet("/viewclient")
public class viewclient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewclient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    DBConnection connection = new DBConnection();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int b=Integer.parseInt(request.getParameter("orgid"));
        System.out.println("print partner id="+b);
        
try
{
	
	Connection con=connection.getConnection();	
	Statement statement = (Statement) con.createStatement();
	System.out.println("before query");
		ResultSet rs3=statement.executeQuery("select * from dms.defect_info where id="+b+"");
		System.out.println("after query"+b);
		  RequestDispatcher rd3= null;
		  request.setAttribute("viewpartner1", rs3);  
		  System.out.println("afetr request");
		  rd3=request.getRequestDispatcher("/view.jsp");
    	   rd3.forward(request, response);
    	   
		

	}
catch (SQLException e) {

	e.printStackTrace();
} catch (Exception e) {
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
