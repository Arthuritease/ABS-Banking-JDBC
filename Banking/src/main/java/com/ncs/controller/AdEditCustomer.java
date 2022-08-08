package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class AdEditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		HttpSession session = request.getSession();
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		
		session.setAttribute("customerID",customerID);
		m.setCustomerID(customerID);

		
		// Call method to get relevant data from select * from customer
		int modelResult = m.AdEditCus();
		//Assigning data to variables from model using getters. You cant get before method from model is called
		int customerId=m.getCustomerID();
		Integer id = new Integer(customerID);
		String name=m.getName();
		String customerUN=m.getCustomerUN();
		String customerPW=m.getCustomerPW();
		String customerEmail =m.getCustomerEmail();
		int balance = m.getBalance();
		Integer bal=new Integer(balance);
		String secA=m.getSecA();
		//Setting to session for displaying
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("customerUN", customerUN);
		session.setAttribute("customerPW", customerPW);
		session.setAttribute("customerEmail", customerEmail);
		session.setAttribute("bal", bal);
		session.setAttribute("secA", secA);
		
		System.out.println("id: "+id);
		System.out.println("name: "+name);
		System.out.println("customerUN: "+customerUN);
		System.out.println("customerPW: "+customerPW);
		System.out.println("customerEmail: "+customerEmail);
		System.out.println("bal: "+bal);

		System.out.println(modelResult);
		response.sendRedirect("/Banking/AdEditCustomer.jsp");
	}

}
