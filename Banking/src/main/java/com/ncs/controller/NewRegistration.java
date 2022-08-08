package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;
//import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;


public class NewRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creating variables and assigning value by getting it via user input
		String newName = request.getParameter("newName");
		String newUN = request.getParameter("newUN");
		String newPW = request.getParameter("newPW");
		String newEmail = request.getParameter("newEmail");
		String rePW = request.getParameter("rePW");
		String secA = request.getParameter("secA");
		HttpSession session = request.getSession();
		session.setAttribute("name", newName);

		
		//call insert method from model
		Model1 m = new Model1();
		//set the values of variables into model for use
		m.setNewID(0);
		m.setNewName(newName);
		m.setNewUN(newUN);
		m.setNewPW(newPW);
		m.setRePW(rePW);
		m.setNewEmail(newEmail);
		m.setBalance(1000);
		m.setSecA(secA);
		int modelResult = m.customerRegistration();
		if(modelResult==1) {
			response.sendRedirect("/Banking/RegSuccess.jsp");
		}
		else if(modelResult==0){
			
		}
		else if(modelResult==-2) {
			response.sendRedirect("/Banking/RegFailure.jsp");
		}
		else {
			response.sendRedirect("/Banking/RegPWFailure.jsp");
		}
		
	}

}
