package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class ChangeParticulars extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
				
		String newName = request.getParameter("newName");
		String newEmail= request.getParameter("newEmail");
		String secA = request.getParameter("secA");
		HttpSession session = request.getSession();
		String customerUN = (String)session.getAttribute("customerUN");
		System.out.println(customerUN);
		m.setNewName(newName);
		m.setNewEmail(newEmail);
		m.setCustomerUN(customerUN);
		m.setSecA(secA);
		int modelResult = m.changeParticulars();
		System.out.println(modelResult);
		if(modelResult==1) {
			response.sendRedirect("/Banking/ChangePartSuccess.jsp");
		}
		else {
			response.sendRedirect("/Banking/ChangePartFailure.jsp");
		}
				
		
	}

}
