package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class AdDeleteTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		HttpSession ses = request.getSession();
		int intTransID = Integer.parseInt(request.getParameter("transID"));
		Integer transID = new Integer(intTransID);
		m.setTransID(transID);
		int modelResult=m.adDeleteTrans();
		m.getTransID();
		int tempTransAmt=m.getTransAmt();
		String transType=m.getTranstype();
		String customerUN= m.getCustomerUN();
		Integer transAmt=new Integer(tempTransAmt);
		
		//Set attribute for the motherfucking JSP
		ses.setAttribute("transID", transID);
		ses.setAttribute("transAmt", transAmt);
		ses.setAttribute("transType", transType);
		ses.setAttribute("customerUN", customerUN);
		
		response.sendRedirect("/Banking/AdDeleteTransactionSuccess.jsp");
	}

}
