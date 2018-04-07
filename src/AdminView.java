

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
 * Servlet implementation class view
 */
@WebServlet("/AdminView")
public class AdminView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * DBConnection connection = new DBConnection();
	 */
    DBConnection connection = new DBConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("I am inside doGet");
		
		int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("print partner id="+id);
        
try
{
	
	Connection con=connection.getConnection();	
	Statement statement = (Statement) con.createStatement();
	System.out.println("before query");
		ResultSet rs1=statement.executeQuery("select * from dms.defect_info where id="+id+"");
		System.out.println("after query"+id);
		  RequestDispatcher rd= null;
		  request.setAttribute("viewbug", rs1);  
		  System.out.println("afetr request");
		  rd=request.getRequestDispatcher("/adminview.jsp");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("I am inside doPost");
		
		doGet(request, response);
	}

}
