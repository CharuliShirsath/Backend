package com.fb;
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	@WebServlet("/add")
	public class Demo_1 extends HttpServlet{

		  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			        throws ServletException, IOException
			    {
			        int a=5;
			        int b=4;
			        
			        System.out.println("Result: "+a+b);
			        
			    }

	}

	
	
