


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
			String name=(String)session.getAttribute("name");
			String recipientUN=request.getParameter("recipientUN");
			String customerPW=request.getParameter("customerPW");
			int transAmt =Integer.parseInt(request.getParameter("transAmt"));
			Integer amtToPrint=new Integer(transAmt);
			
			m.setCustomerUN(customerUN);
			m.setCustomerPW(customerPW);
			m.setRecipientUN(recipientUN);
			m.setTransAmt(transAmt);
			
			m.setTransID(0);
			
		
			int modelResult=m.sendMoney();
			session.setAttribute("recipientUN", recipientUN);
			session.setAttribute("name", name);
			session.setAttribute("amtToPrint", amtToPrint);
			System.out.println("modelResult :"+modelResult);
			if(modelResult ==1) {
				System.out.println("it works!");
				response.sendRedirect("/Banking/TransferSuccess.jsp");
			} else if(modelResult==-1){
				System.out.println("Wrong pw from transferer. Sent from Controller");
				response.sendRedirect("/Banking/TransferPWFailure.jsp");
			}else if(modelResult==-2) {
				System.out.println("Incorrect recipient username. Sent from controller");
				response.sendRedirect("/Banking/TransferUNFailure.jsp");
			}else if(modelResult==-3) {
				System.out.println("Transfer amount too high. Sent from Controller");
				response.sendRedirect("/Banking/TransferAmtFailure.jsp");
			}
			
			
			
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
