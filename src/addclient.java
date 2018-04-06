

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dexpert.main.databaseconnection.DBConnection;

/**
 * Servlet implementation class addclient
 */
@WebServlet("/addclient")
public class addclient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addclient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    DBConnection connection = new DBConnection();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/aashish1","root",""); 
		
			Connection con=connection.getConnection();
			Statement stmt=con.createStatement();
			
			String organization_name   =request.getParameter("organization_name");
			String relationship_type   =request.getParameter("relationship_type");
			String reffer_Partner_Idfk =request.getParameter("reffer_Partner_Idfk");
			
			String fname       			=request.getParameter("first_name");
			String lname  				=request.getParameter("last_name");
			String gender 				=request.getParameter("gender");
			String contact 				=request.getParameter("contact");
			String email 				=request.getParameter("email_address");
			String address 				=request.getParameter("address");
			String industry_type 		=request.getParameter("industry_type");
			String segment 				=request.getParameter("segment");
			String sub_segment 			=request.getParameter("sub_segment");
		System.out.println("before ststement");
			 PreparedStatement pst =(PreparedStatement) con.prepareStatement("insert into tendrilla.organization_master(organizationid,"
			 		+ "organization_name,relationship_type,reffer_Partner_Idfk,first_name,last_name,gender,email_address,"
			 		+ "contact_no,address,industry_type,segment,sub_segment) "
			 		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");//try2 is the name of the table  
			 System.out.println("after ststement");
			 Random rand= new Random();
			 int pick = rand.nextInt(900) + 100;
			 
			 pst.setInt(1,pick);
			 pst.setString(2,organization_name);
			 pst.setString(3,relationship_type);  
	          pst.setInt(4,pick);        
	          pst.setString(5,fname);
	          pst.setString(6,lname);
	          pst.setString(7,gender);
	          pst.setString(8,email);
	          pst.setString(9,contact);
	          pst.setString(10,address);
	          pst.setString(11,industry_type );
	          pst.setString(12,segment);
	          pst.setString(13,sub_segment);
	          
	           pst.executeUpdate();
	         

	          pst.close();
		}
		
		 catch (SQLException e) {
			e.printStackTrace();  
		 } catch (Exception e) {
			// TODO: handle exception
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
