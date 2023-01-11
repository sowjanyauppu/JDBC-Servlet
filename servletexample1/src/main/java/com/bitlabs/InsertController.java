package com.bitlabs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class InsertController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		System.out.println("hello");
		String str1=req.getParameter("t1");
		String str2=req.getParameter("t2");
		int a=Integer.parseInt(str1);
		int b=Integer.parseInt(str2);
		int result=a+b;
		PrintWriter out=res.getWriter();
		
		out.print("result:   "+result);
					
		
	}

}



