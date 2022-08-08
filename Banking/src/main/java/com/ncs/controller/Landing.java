package com.ncs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Landing
 */
public class Landing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Redirecting to landing.html(view)
		response.sendRedirect("/Banking/landing.html");	
//		RequestDispatcher landingDisp = request.getRequestDispatcher("landing.html");
//		landingDisp.forward(request,response);
	}
	
	

}
