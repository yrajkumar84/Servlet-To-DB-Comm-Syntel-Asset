package com.db.conn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Asset_Allocation_Page  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String status=null;
		
		String name=null,projid=null,verti=null,tickt=null;
		String ename=null,EmpId=null;
		//Enort=null;
		String Flbuild=null,Flwing=null,Flfloor=null,FlDesk=null;
		String Asid=null,Asserial=null,Asdate=null,Ashost=null;
		
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		
		//project details 
		name=req.getParameter("projname");
		projid=req.getParameter("projtid");
		verti=req.getParameter("vertical");
		tickt=req.getParameter("pticket");
		
		//Employee details
		ename=req.getParameter("empname");
		EmpId=req.getParameter("empid");
	//	Enort=req.getParameter("nortel");
		
		//project details 
		Flbuild=req.getParameter("building");
		Flwing=req.getParameter("floor");
		Flfloor=req.getParameter("wing");
		FlDesk=req.getParameter("desk");
		
		//Asset details
		Asid=req.getParameter("assetid");
		Asserial=req.getParameter("serialno");
		Asdate=req.getParameter("allocdate");
		Ashost=req.getParameter("hostname");


		status=req.getParameter("vflag");
		System.out.println(status);
		
		if (status.equals("no")) {
			System.out.println(status);
	/*
	 * Flbuild=null,Flwing=null,Flfloor=null,FlDesk=null;
	 * name=null,projid=null,verti=null,tickt=null;
	 * "+Asserial+","+Asdate+","+Ashost+","+verti+"
	 *Asid=null,Asserial=null,Asdate=null,Ashost=null;
	 * //Project details 
	 */
			// Project name
			if (name.equalsIgnoreCase("") || name.length()==0 || name==null ) {
				pw.println("<h5>Project name req");
				return;
			}
			//project id 
			if (projid.equalsIgnoreCase("") || projid.length()==0 || projid==null ) {
				pw.println("<h5>project id req");
				return;
			}
			//vertical details
			if (verti.equalsIgnoreCase("") || verti.length()==0 || verti==null ) {
				pw.println("<h5>verticals details req");
				return;
			}
			//ticket no
			if (tickt.equalsIgnoreCase("") || tickt.length()==0 || tickt==null ) {
				pw.println("<h5>Ticket no  req");
				return;
			}
	
	/*
	 * // EMployee details 
	 */
			
			//Employee name
			if (ename.equalsIgnoreCase("") || ename.length()==0 || ename==null ) {
				pw.println("<h5>Employee name req");
				return;
			}
			//Employee ID
			if (EmpId.equalsIgnoreCase("") || EmpId.length()==0 || EmpId==null ) {
				pw.println("<h5>Employee ID req");
				return;
			}
			// Nortel Number
				/*
				 * if (Enort.equalsIgnoreCase("") || Enort.length()==0 || Enort==null ) {
				 * pw.println("<h5>Extension  req"); return; }
				 */
			
	/*
	 * //Floor Details 
	 */
			
			// building
			if (Flbuild.equalsIgnoreCase("") || Flbuild.length()==0 || Flbuild==null ) {
				pw.println("<h5>Req Building details");
				return;
			}
			//floor details
			if (Flfloor.equalsIgnoreCase("") || Flfloor.length()==0 || Flfloor==null ) {
				pw.println("<h5>Req Floor details");
				return;
			}
	
			//Wing details 
			if (Flwing.equalsIgnoreCase("") || Flwing.length()==0 || Flwing==null ) {
				pw.println("<h5>Req Wing details");
				return;
			}
			//Desk  no
			if (FlDesk.equalsIgnoreCase("") || FlDesk.length()==0 || FlDesk==null ) {
				pw.println("<h5>Req desk no");
				return;
			}
			
	/*
	 * Asset details
	 * 
	 *
	 */
			// building
			if (Asid.equalsIgnoreCase("") || Asid.length()==0 || Asid==null ) {
				pw.println("<h5>Req Asset id");
				return;
			}
			//floor details
			if (Asserial.equalsIgnoreCase("") || Asserial.length()==0 || Asserial==null ) {
				pw.println("<h5>Req Serials");
				return;
			}
	
			//Wing details 
			if (Asdate.equalsIgnoreCase("") || Asdate.length()==0 || Asdate==null ) {
				pw.println("<h5>Req Allocation date");
				return;
			}
			//Desk  no
			if (Ashost.equalsIgnoreCase("") || Ashost.length()==0 || Ashost==null ) {
				pw.println("<h5>Req Hostname");
				return;
			}
		
			System.out.println("validation completed");
		}
		
		/*
		 * 
		 */
		
		try {
			
			 Class.forName("oracle.jdbc.driver.OracleDriver");  
		      
			    //step2 create  the connection object  
			     con=DriverManager.getConnection(  
			    "jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");  
			
			/*ServletConfig cg=getServletConfig();
			
			String s1=cg.getInitParameter("driver");
			String s2=cg.getInitParameter("dburl");
			String s3=cg.getInitParameter("dbuser");
			String s4=cg.getInitParameter("dbpwd");

			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);*/
			int sr_no=0;
			ps1=con.prepareStatement("select max(sr_no) from asset_syntel");
			ResultSet rs=ps1.executeQuery();
			 
			if (rs.next()) {
				sr_no=rs.getInt(1);
				sr_no++;
				System.out.println(sr_no);
				
				String query="insert into asset_syntel values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				ps=con.prepareStatement(query);
				
				ps.setInt(1,sr_no);
				ps.setString(2,name);
				ps.setString(3,projid);
				ps.setString(4,verti);
				ps.setString(5,tickt);
			
				ps.setString(6,Flbuild);
				ps.setString(7,Flfloor);
				ps.setString(8,Flwing);
				ps.setString(9,FlDesk);
				
				ps.setString(10,ename);
				ps.setString(11,EmpId);
				
				ps.setString(12,Asid);
				ps.setString(13,Asserial);
				ps.setString(14,Asdate);
				ps.setString(15,Ashost);
				
				int i=ps.executeUpdate();
				if (i>0) {
					pw.print("<h2>inserted</h2>");
				} else {
					pw.print("<h3> not iserted</h3>");
				}
				//System.out.println(query);
			}
			
			
			System.out.println(status);
		
	} catch (Exception e) {
			e.printStackTrace();
	}finally {
		
		try {
			ps.close();
			ps1.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		
		
		pw.print("<b> hi hello</b>" );
		//System.out.println(tno+" "+projid+" "+verti);
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		doGet(req, res);
	}
	
}
