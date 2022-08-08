package com.ncs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model1.Model1;


public class FilterID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model1 m = new Model1();
		int filterID =Integer.parseInt(request.getParameter("filterID"));
		m.setFilterID(filterID);
		System.out.println("filterId from servlet :"+filterID);
		ArrayList<TransList> t = m.filteredTransaction();
		
		HttpSession session = request.getSession();
		
		
		int uniqueTransID=m.getUniqueTransID();
		Integer uniqueID=new Integer(uniqueTransID);
		session.setAttribute("uniqueTransID", uniqueID);
		System.out.println(t);
		session.setAttribute("t", t);
		for(Object individualTransaction:t) {
			System.out.println("From servlet "+individualTransaction.toString());
		}
		response.sendRedirect("/Banking/ListOfFilteredTrans.jsp");
	}

}
