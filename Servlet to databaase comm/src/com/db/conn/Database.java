package com.db.conn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Database  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ename=null,pass1=null;
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		try {
			ename=req.getParameter("username");
			pass1=req.getParameter("password");
		 Class.forName("oracle.jdbc.driver.OracleDriver");  
	      
		    //step2 create  the connection object  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");  
		      
		    //step3 create the statement object  
		    PreparedStatement ps=con.prepareStatement("select * from login where username=? and password=?");  
		      
		    ps.setString(1,ename);
		    ps.setString(2, pass1);
		    //step4 execute query  
		    ResultSet rs=ps.executeQuery();  
		   
		   
			//
		  
		    if(rs.next())  {
		    	pw.print("<h2> welcome</h2>");
		        System.out.println(rs.getString(1)+"  "+rs.getString(2));
		       // pw.println(rs.getString(1)+"  "+rs.getString(2));
		          
		        //step5 close the connection object  
		    
		    }
		    System.out.println("wrong");
		    con.close();  
	
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
