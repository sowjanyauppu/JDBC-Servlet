package com.bitlabs;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
@MultipartConfig(maxFileSize = 1000000000)      //user can upto upto 1GB
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("usr");
		String pwd = request.getParameter("pwd");
		Part filePart = request.getPart("fname");
		InputStream input =null;
		if(filePart !=null)
		{
			input = filePart.getInputStream();  //converting to bytes
			
		}
		
		//connecting to database
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlabs","root","root");
			 if(con!=null) {
			    	System.out.println("Done");
			    }
			 
			 String query = "insert into FileDemo values(?,?,?)";
			 PreparedStatement pstmt= con.prepareStatement (query);//database field names
		     pstmt.setString(1, name);
		     pstmt.setString(2, pwd);
		     if(input!=null)
		     {
		    	 int size=(int)filePart.getSize();
		    	 pstmt.setBinaryStream(3, input, size);
		     }
		     
		     int num = pstmt.executeUpdate();
		     
		     if(num>0)
		     {
		    	 response.setContentType("text/html");
		    	 PrintWriter out = response.getWriter();
		    	 out.println("file inserted successfully into the database");
		    	 
		     }
		     con.close();	
		
	    } catch(Exception e) {
		e.printStackTrace();
	}
	}
	

}
