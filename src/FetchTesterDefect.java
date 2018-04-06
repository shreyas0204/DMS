

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
import javax.servlet.http.HttpSession;

import com.dexpert.main.databaseconnection.DBConnection;


/**

 * Servlet implementation class FetchClient
 */
@WebServlet("/FetchClient")
public class FetchTesterDefect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchTesterDefect() {
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
	       HttpSession session=request.getSession(); 
	       Integer testerid =(Integer) session.getAttribute("sessionID");
	   
	      // System.out.println("got partner id from session as::"+testerid);
		
		try{
		
			Connection con1=connection.getConnection();
			Statement statement = (Statement) con1.createStatement();
			
			 

			 //System.out.println("partner is recived is::"+partnerid);
			
	        ResultSet rs =statement.executeQuery("SELECT * FROM dms.defect_info where tester_id="+testerid); 
	        RequestDispatcher rd= null;
	        
	       //System.out.println(" after partner recived is after query::"+testerid);
	        if(rs.next()){
	        	Integer id = rs.getInt("id");
	     	   request.setAttribute("testerlist", rs);   	  
	     	   rd=request.getRequestDispatcher("/testerlist.jsp");
	     	   rd.forward(request, response);
	     	   
	        }   
	        else{
	     	   
	     	   request.setAttribute("testerlist", rs);
	     	   
	     	   rd=request.getRequestDispatcher("/testerlist.jsp");

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
