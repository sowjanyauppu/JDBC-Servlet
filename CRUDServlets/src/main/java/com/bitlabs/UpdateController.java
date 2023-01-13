package com.bitlabs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
	String username=req.getParameter("t1");
	String password=req.getParameter("t2");
	
	System.out.println(username);
	System.out.println(password);
	
	DaoImpl obj=new DaoImpl();
	User u=new User();
	u.setUsername(username);
	u.setPassword(password);
	
	
	boolean b=obj.update(u);
	
	if(b) {
		try {
			PrintWriter pw=res.getWriter();
			pw.println("<body><h1> password changed successful </h1><body>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else {
		try {
			PrintWriter pw=res.getWriter();
			pw.println("<body><h1>  password was not changed successful</h1><body>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
}
