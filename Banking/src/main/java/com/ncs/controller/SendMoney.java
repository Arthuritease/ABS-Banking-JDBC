package com.ncs.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class SendMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Model1 m = new Model1();
			HttpSession session = request.getSession(true);
			String customerUN=(String)session.getAttribute("customerUN");
			String recipientUN=request.getParameter("recipientUN");
			String customerPW=request.getParameter("customerPW");
			int transAmt =Integer.parseInt(request.getParameter("transAmt"));
			m.setCustomerUN(customerUN);
			m.setCustomerPW(customerPW);
			m.setRecipientUN(recipientUN);
			m.setTransAmt(transAmt);
			
			int modelResult=m.sendMoney();
			int uniqueTransID=m.getUniqueTransID();
			System.out.println("unique id: "+uniqueTransID);
			if(modelResult ==1) {
				System.out.println("it works!");
			} else if(modelResult==-1){
				System.out.println("Either password don't match or transAmt too much");
			}else {
				System.out.println("Session ultimately did not get customerUN. Sent from controller");
			}
			
			
			
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
