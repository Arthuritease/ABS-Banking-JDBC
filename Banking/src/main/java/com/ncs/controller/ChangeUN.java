package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class ChangeUN extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		
		String newPW = request.getParameter("newPW");
		String rePW= request.getParameter("rePW");
		String secA = request.getParameter("secA");
		System.out.println(newPW+" "+rePW+" "+secA);
		HttpSession session = request.getSession();
		String customerUN = (String)session.getAttribute("customerUN");
		System.out.println(customerUN);
		
		if(newPW.equals(rePW)) {
			m.setNewPW(newPW);
			m.setCustomerUN(customerUN);
			m.setSecA(secA);
			System.out.println("secA from servlet: "+secA);
			int modelResult = m.changePassword();
			if(modelResult==1) {
				response.sendRedirect("/Banking/ChangePWSuccess.jsp");
			}
			else if(modelResult==-1){
				System.out.println("secA tak match");
				response.sendRedirect("/Banking/ChangePWSecurityFailure.jsp");
			}
		}else {
			response.sendRedirect("/Banking/ChangePWFailure.jsp");
		}
		
		
		
	}

}
