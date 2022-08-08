package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		String customerUN = request.getParameter("customerUN");
		String customerPW = request.getParameter("customerPW");
		String name;
		
		
		System.out.println("Controller accessed");

		
		m.setCustomerUN(customerUN);
		m.setCustomerPW(customerPW);
		int modelResult = m.verifyCustomer();
		name = m.getName();


		
		
		HttpSession session = request.getSession(true);
		session.setAttribute("name", name);
		session.setAttribute("customerUN", customerUN);

		
		
		System.out.println(name);
		if(modelResult==1) {
			response.sendRedirect("/Banking/CustomerSuccess.jsp");
		}else if(modelResult==0){
			response.sendRedirect("/Banking/CustomerUNFailure.jsp");
		}else {
			response.sendRedirect("/Banking/CustomerPWFailure.jsp");
		}
		}

}