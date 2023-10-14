package com.fb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dis-user")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String data=request.getParameter("nm");
		//-----------------We have to write here DB Code---------------------------------
		
		[]
		
		//------------------------------------------------------------------
		System.out.println("GET-->"+data);
		request.setAttribute("result", "Hello "+data);
		request.getRequestDispatcher("data.jsp").forward(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String data=request.getParameter("nm");
		//System.out.println("POST-->we are in GET Method");

	}

}
