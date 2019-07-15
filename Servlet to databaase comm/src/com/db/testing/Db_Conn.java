package com.db.testing;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Db_Conn extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		String ename=null,pass1=null;
	
		
		ename=req.getParameter("user");
	//	ename=ename.toUpperCase();
		pass1=req.getParameter("pass");
		
		Connection con=null;
		PreparedStatement ps=null;
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		
	try {
			//PrintWriter pw1=new PrintWriter(new File("C:\\Users\\Rajkumar Yadav\\Desktop\\test.csv"));
				//StringBuilder sb=new StringBuilder();
				
				
				ServletConfig cg=getServletConfig();
				
				String s1=cg.getInitParameter("driver");
				String s2=cg.getInitParameter("dburl");
				String s3=cg.getInitParameter("dbuser");
				String s4=cg.getInitParameter("dbpwd");

				Class.forName(s1);
				con=DriverManager.getConnection(s2,s3,s4);
			//	System.out.println(pass1);
				
				ps=con.prepareStatement("select ename,job from emp where ename=? and job=?");
				
				ps.setString(1, ename);
				ps.setString(2, pass1);
				ResultSet rs=ps.executeQuery();
			//	pw.println("Enpno"+"  "+"Ename");
				pw.println("<br>");
			while  (rs.next()) {
					
				/*
				 * sb.append(rs.getString("empno")); sb.append(",");
				 * sb.append(rs.getString("ename")); sb.append("\n");
				 */
				//	pw.println("<h1>'rs.getString("Ename")'");//+"  "+rs.getString("Job")");
					pw.println("<br>");
					System.out.println(rs.getString("ENAME"));
					//pw.print("<h1>done woith </h1>: rs.getString('JOB')");
				/*
				 * pw.println(rs.getInt(1)+"  "+rs.getString(2)+"  " +rs.getString(3));
				 * pw.println("<br>"); //System.out.println(ename);
				 */
			}
			//pw1.write(sb.toString());
				
			pw.close();//pw1.close();
				/*
				 * // System.out.println(uname1 +" "+pass1);
				 * pw.print("enter valid credentials");
				 */
	
			
		
		}//  try 
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * if(uname1.equalsIgnoreCase("raj") && pass1.equalsIgnoreCase("rajkumar")) {
		 * pw.print("<h2> login success"); } else pw.print("enter valid credentials");
		 */
}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}
	
	
}
