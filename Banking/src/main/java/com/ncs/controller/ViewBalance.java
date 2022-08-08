package com.ncs.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class ViewBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		HttpSession session = request.getSession();
		String customerUN = (String)session.getAttribute("customerUN");

		m.setCustomerUN(customerUN);
		
		int modelResult = m.viewbalance();
		int balance = m.getBalance();
		Integer bal=new Integer(balance);
		session.setAttribute("bal", bal);
		System.out.println("bal: "+bal);

		System.out.println(modelResult);
		if(modelResult==1) {
			response.sendRedirect("/Banking/cusViewBalance.jsp");
		}
		else {
			response.sendRedirect("/Banking/ViewBalanceFailure.jsp");
		}

	}
}
