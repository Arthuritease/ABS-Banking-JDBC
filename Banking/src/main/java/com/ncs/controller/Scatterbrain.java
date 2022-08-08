package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class Scatterbrain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		Model1 m = new Model1();
		//Assigning values to variables via user input
		String customerUN=request.getParameter("customerUN");
		String name=request.getParameter("name");
		String secA=request.getParameter("secA");
		
		//Set variables for model to retrieve
		m.setCustomerUN(customerUN);
		m.setName(name);
		m.setSecA(secA);
		//Set name to session to display in JSP
		ses.setAttribute("name", name);
		ses.setAttribute("customerUN", customerUN);
		int modelResult = m.scatterBrain();
		if(modelResult == 1) {
			response.sendRedirect("/Banking/UpdatePW.jsp");
		}else if(modelResult==-1) {
			response.sendRedirect("/Banking/ScatterbrainSecurityFailure.jsp");
		}else {
			response.sendRedirect("/Banking/ScatterbrainUNFailure.jsp");
		}
	}
	
}
