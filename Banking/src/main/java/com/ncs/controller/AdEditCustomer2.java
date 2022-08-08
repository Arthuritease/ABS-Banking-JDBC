package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class AdEditCustomer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		HttpSession ses = request.getSession();
		//For integer, getting data from session, you need to typecast
		int customerID = (int) ses.getAttribute("customerID");
		//Then you typecast it again to an object for JSP to grab and display
		Integer cusID = new Integer(customerID);
		
		//Throw this into model for setString/setInt
		m.setCustomerID(customerID);
		System.out.println("customerID: "+customerID);
		String newName = request.getParameter("newName");
		
		String newUN = request.getParameter("newUN");
		String newPW = request.getParameter("newPW");
		String newEmail = request.getParameter("newEmail");
		int newBalance = Integer.parseInt(request.getParameter("newBalance"));
		Integer bal = new Integer(newBalance);
		String secA=request.getParameter("secA");
		//Also throwing into model
		m.setNewName(newName);
		m.setNewUN(newUN);
		m.setNewPW(newPW);
		m.setNewEmail(newEmail);
		m.setNewBalance(newBalance);
		m.setSecA(secA);
		
		//Setting session information for JSP to grab and display
		ses.setAttribute("id", cusID);
		ses.setAttribute("name", newName);
		ses.setAttribute("customerUN", newUN);
		ses.setAttribute("customerPW", m.encrypt(newPW));
		ses.setAttribute("customerEmail", newEmail);
		ses.setAttribute("balance", bal);
		ses.setAttribute("secA", secA);
		
		int modelResult=m.AdEditCus2();
		if(modelResult==1) {
			response.sendRedirect("/Banking/AdEditCustomerSuccess.jsp");
		}
		else {
			System.out.println("Help sia..");
		}	
	}
}


