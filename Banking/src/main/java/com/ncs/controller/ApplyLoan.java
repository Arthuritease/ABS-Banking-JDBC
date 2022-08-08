package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class ApplyLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		HttpSession ses = request.getSession();
		String name = (String)ses.getAttribute("name");
		String customerUN=(String)ses.getAttribute("customerUN");
		String loanType = request.getParameter("loanType");
		String loanTenure = request.getParameter("loanTenure");
		int loanAmount = Integer.parseInt(request.getParameter("loanAmt"));
		//loanAmt is for printing on jsp
		Integer loanAmt = new Integer(loanAmount);
		ses.setAttribute("loanAmt", loanAmt);
		ses.setAttribute("loanTenure", loanTenure);
		ses.setAttribute("loanType", loanType);
		
		m.setCustomerUN(customerUN);
		m.setLoanAmt(loanAmount);
		m.setLoanType(loanType);
		m.setLoanID(0);
		int modelResult=m.applyLoan();
		System.out.println("modelResult: "+modelResult);
		if(modelResult==1) {
			response.sendRedirect("/Banking/LoanSuccess.jsp");
		}else if(modelResult==-1) {
			response.sendRedirect("/Banking/LoanAmtFailure.jsp");
		}else {
			response.sendRedirect("/Banking/LoanActiveFailure.jsp");
		}
	}

}
