

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dexpert.main.databaseconnection.DBConnection;


/**
 * Servlet implementation class FetchPartner
 */
@WebServlet("/FetchPartner")
public class FetchPartner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchPartner() {
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
		try{
		/*	Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tendrilla","root","");
			*/
			Connection con=connection.getConnection();
			Statement statement = (Statement) con.createStatement();
	        ResultSet rs =statement.executeQuery("select * from defect_info"); 
	        RequestDispatcher rd= null;
	        if(rs.next()){
	     	   
	     	   request.setAttribute("defectList", rs);   	  
	     	
	     	   
	     	   rd=request.getRequestDispatcher("/partnersList.jsp");
	     	   rd.forward(request, response);
	     	   
	        }   
	        else{
	     	   
	     	   request.setAttribute("partnersList", rs);
	     	   
	     	   rd=request.getRequestDispatcher("/partnersList.jsp");
	     	   rd.forward(request, response);  	   
	        }
	     	
	 	  }  
	        		
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
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
