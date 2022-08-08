package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class ViewCustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		ArrayList<CustomerList> c = m.viewCustomerList();
		HttpSession session = request.getSession();
		
		
		
		session.setAttribute("c", c);
		System.out.println(c);
		for(Object individualCustomers:c) {
			m.setCustomerUN("customerUN");
			m.setCustomerPW("customerPW");
			m.setCustomerID(0);
			
			System.out.println("From servlet "+individualCustomers.toString());
		}
		response.sendRedirect("/Banking/ListOfCustomer.jsp");

		
	}

}
