

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
 * Servlet implementation class FetchTesterDefect
 */
@WebServlet("/FetchTesterDefect")
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
	       String partnerid =(String) session.getAttribute("PARTNERID");
	   
	       //System.out.println("got partner id from session as::"+partnerid);
		
		try{
		
			Connection con1=connection.getConnection();
			Statement statement = (Statement) con1.createStatement();
			
			 

			 //System.out.println("partner is recived is::"+partnerid);
			
	        ResultSet rs =statement.executeQuery("SELECT * from organization_master om,partners_master pm where om.reffer_Partner_Idfk=pm.partnerId  and pm.partnerId='"+partnerid+"'"); 
	        RequestDispatcher rd= null;
	        
	       // System.out.println(" after partner recived is after query::"+partnerid);
	        if(rs.next()){
	     	   
	        	
	        	  String orgname = rs.getString("organization_name");
	     	   request.setAttribute("AllclientList", rs);   	  
	     	System.out.println("got records from db"+orgname);
	     	   
	     	   rd=request.getRequestDispatcher("/clientlist.jsp");
	     	   rd.forward(request, response);
	     	   
	        }   
	        else{
	     	   
	     	   request.setAttribute("clientList", rs);
	     	   
	     	   rd=request.getRequestDispatcher("/clientlist.jsp");
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
