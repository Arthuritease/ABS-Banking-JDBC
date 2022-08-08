package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class RejectLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		HttpSession ses = request.getSession();
		int loanID = Integer.parseInt(request.getParameter("loanID"));
		m.setLoanID(loanID);
		ses.setAttribute("loanID", loanID);
		int modelResult = m.rejectLoans();
		String loanUN=m.getLoanUN();
		ses.setAttribute("loanUN", loanUN);
		response.sendRedirect("/Banking/RejectedLoans.jsp");
		
		
	}
	

}
