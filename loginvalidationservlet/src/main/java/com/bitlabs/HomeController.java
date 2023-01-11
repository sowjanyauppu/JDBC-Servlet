package com.bitlabs;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitlabs.model.Login;
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String uname=req.getParameter("t1");
		String pwd=req.getParameter("t2");
		Login l=new Login();
		l.setUname(uname);
		l.setPwd(pwd);
		boolean b=new Validation().validate(l);
		PrintWriter out=res.getWriter();
		if(b)
		{
			out.println("<body bgcolor=cyan> valid user </body>");
		}
		else
		{
			out.println("<body bgcolor=yellow> In valid user </body>");
		}
	}
}
