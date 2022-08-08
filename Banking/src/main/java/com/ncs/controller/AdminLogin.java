package com.ncs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.ncs.model.Model;
import com.ncs.model1.Model1;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminUN = request.getParameter("adminUN");
		String adminPW = request.getParameter("adminPW");
		HttpSession session = request.getSession(true);
		session.setAttribute("adminUN", adminUN);
		
		System.out.println("Controller");
		Model1 m = new Model1();
		
		m.setAdminUsername(adminUN);
		m.setAdminPassword(adminPW);
		int modelResult = m.verifyAdmin();
		if(modelResult==1) {
			response.sendRedirect("/Banking/AdminSuccess.jsp");
		}else if(modelResult==0){
			response.sendRedirect("/Banking/AdminUNFailure.jsp");
		}else {
			response.sendRedirect("/Banking/AdminPWFailure.jsp");
		}
}

}
