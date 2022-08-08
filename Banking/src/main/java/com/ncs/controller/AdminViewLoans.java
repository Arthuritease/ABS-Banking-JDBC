package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class AdminViewLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		ArrayList<LoanList> l = m.viewLoans();
		HttpSession session = request.getSession();
		
		System.out.println(l);
		
		session.setAttribute("l", l);
		for(Object individualLoans:l) {
			System.out.println("From servlet "+individualLoans.toString());
		}
		response.sendRedirect("/Banking/ListOfLoans.jsp");

		
	}

}
