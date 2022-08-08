package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class AdDeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		HttpSession ses = request.getSession();
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		m.setCustomerID(customerID);
		
		//Dont fucking forget this or JSP can't read shit.
		ses.setAttribute("customerID", customerID);
		int modelResult = m.AdDeleteCus();
		System.out.println("dude has been deleted");
		response.sendRedirect("/Banking/AdDeleteCusSuccess.jsp");
	}

}
