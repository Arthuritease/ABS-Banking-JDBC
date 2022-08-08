package com.ncs.model1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import com.ncs.controller.CustomerList;
import com.ncs.controller.LoanList;
import com.ncs.controller.TransList;

public class Model1 {



	private int customerID;
	private int newID;
	private int balance;
	private int transAmt;
	private int transID;
	private int uniqueTransID;
	private int filterID;

	public int getFilterID() {
		return filterID;
	}
	public void setFilterID(int filterID) {
		this.filterID = filterID;
	}

	private int newBalance;

	


	private int loanAmt;
	private int loanID;
	
	

	private String loanType;
	private String loanStatus="Pending";
	private String loanUN;
	public String getOgSecA() {
		return ogSecA;
	}
	public void setOgSecA(String ogSecA) {
		this.ogSecA = ogSecA;
	}

	private String ogSecA;



	private String transType;
	private String adminUsername;
	private String adminPassword;
	private String newName;


	private String newUN;
	private String newPW;
	private String newEmail;
	private String secA;
	private String recipientUN;
	
	private String customerUN;
	private String customerPW;
	private String customerEmail;
	private String name;
	private String rePW;
//	private Integer balance2;
	
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	//Setters and getters for loans
	public int getLoanID() {
		return loanID;
	}
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}
	public int getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(int loanAmt) {
		this.loanAmt = loanAmt;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public String getLoanUN() {
		return loanUN;
	}
	public void setLoanUN(String loanUN) {
		this.loanUN = loanUN;
	}
	
	//Setters and getters for Transaction
	
	public int getTransID() {
		return transID;
	}
	public void setTransID(int transID) {
		this.transID = transID;
	}
	public String getTranstype() {
		return transType;
	}
	public void setTranstype(String transtype) {
		this.transType = transtype;
	}
	public int getUniqueTransID() {
		return uniqueTransID;
	}
	public void setUniqueTransID(int uniqueTransID) {
		this.uniqueTransID = uniqueTransID;
	}
	
	//Setters and Getters for admin login

	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	//Setters and Getters for customers login
	public String getCustomerUN() {
		return customerUN;
	}
	public void setCustomerUN(String customerUN) {
		this.customerUN = customerUN;
	}
	public String getCustomerPW() {
		return customerPW;
	}
	public void setCustomerPW(String customerPW) {
		this.customerPW = customerPW;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Setter and getters for Admin to edit customer
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public int getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(int newBalance) {
		this.newBalance = newBalance;
	}
	
	
	//Setters and Getters for Admin to delete customers
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	//Setters and Getters for customer registration
	public int getNewID() {
		return newID;
	}
	
	
	public void setNewID(int newID) {
		this.newID = newID;
	}
	
	public  int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getNewUN() {
		return newUN;
	}
	public void setNewUN(String newUN) {
		this.newUN = newUN;
	}
	public String getNewPW() {
		return newPW;
	}
	public void setNewPW(String newPW) {
		this.newPW = newPW;
	}
	public String getNewEmail() {
		return newEmail;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}
	public String getSecA() {
		return secA;
	}
	public void setSecA(String secA) {
		this.secA = secA;
	}
	
	//Setters and Getters for Updating password
	public String getRePW() {
		return rePW;
	}
	public void setRePW(String rePW) {
		this.rePW = rePW;
	}
	
	//Setters and Getters for transferring money
	public int getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(int transAmt) {
		this.transAmt = transAmt;
	}
	public String getRecipientUN() {
		return recipientUN;
	}
	public void setRecipientUN(String recipientUN) {
		this.recipientUN = recipientUN;
	}
	
	//Working Model
	public Model1() {
		
		try {
			//Driver loading
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Driver Loaded");
			//Driver connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NCSBanking","root","Toxofan91!");
			System.out.println("Connection Established");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	
	//Method to verify admin login. Content TBD
	public int verifyAdmin() {
		try {
			String s = "Select * from Admin where username=?";
		pstmt= con.prepareStatement(s);
		pstmt.setString(1,adminUsername);
		res=pstmt.executeQuery();
		if(res.next()==true){
			if(adminPassword.equals(res.getString(3))){
				
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			return 0;
		}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//Method to verify customer login. Content TBD.
	public int verifyCustomer() {
		try {
			String s= "Select * from Customer where username=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, customerUN);
			res=pstmt.executeQuery();
			
			if(res.next()==true) {
				if(encrypt(customerPW).equals(res.getString(4))) {
					name=res.getString(2);
					balance=res.getInt(6);
					return 1;
				}else {
					return -1;
				}
			}else {
				return 0;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//Method to allow customer registration. DONE.
	public int customerRegistration() {
		try {
			String x = "select * from customer where username=?";
			pstmt=con.prepareStatement(x);
			pstmt.setString(1, newUN);
			res=pstmt.executeQuery();
			if(res.next()!=true) {
				String s ="insert into customer values(?,?,?,?,?,?,?,?)";
				pstmt=con.prepareStatement(s);
				pstmt.setInt(1,newID);
				pstmt.setString(2, newName);
				pstmt.setString(3, newUN);
				if(encrypt(newPW).equals(encrypt(rePW))) {
					pstmt.setString(4, encrypt(newPW));
					pstmt.setString(5, newEmail);
					pstmt.setInt(6, balance);
					pstmt.setString(7, secA);
					pstmt.setInt(8, 0);
					int rows = pstmt.executeUpdate();
					if(rows==1) {
						return 1;
					}else{
						return 0;
					}
					
				}
				else {
						System.out.println("newPW and rePW don't match. Sent from Model");
						return -1;
					}
			}else {
				System.out.println("username exists in system");
				return -2;
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//Method for changing customer password
	
	public int changePassword() {
		try {
			String y = "select * from customer where username=?";
			pstmt = con.prepareStatement(y);
			pstmt.setString(1, customerUN);
			res=pstmt.executeQuery();
			if(res.next()==true) {
				if(secA.equals(res.getString(7))) {
					System.out.println("secA from model: "+secA);
					String x = "update customer set password=? where username=?";
					pstmt=con.prepareStatement(x);
					pstmt.setString(1, encrypt(newPW));
					pstmt.setString(2, customerUN);
					int rows=pstmt.executeUpdate();
					return rows;
				}else{
					return -1;
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for changing customer particulars
	public int changeParticulars() {
		try {
			String x = "update customer set name=?,email=?, security_answer=? where username=?";
			pstmt=con.prepareStatement(x);
			pstmt.setString(1, newName);
			pstmt.setString(2, newEmail);
			pstmt.setString(3, secA);
			pstmt.setString(4, customerUN);
			int rows=pstmt.executeUpdate();
			System.out.println("rows: "+rows);
			System.out.println("name: "+newName+" email: "+newEmail+" customerUN: "+customerUN+ "sec answer: "+secA);
			return rows;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for customer to view their transactions
	
	public ArrayList<TransList> cusViewTransaction(){
		ArrayList<TransList> tList=new ArrayList<TransList>();
		try {
			String y = "select * from transaction where username=?";
			pstmt=con.prepareStatement(y);
			pstmt.setString(1, customerUN);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				TransList eachTrans=new TransList();
				eachTrans.setId(res.getInt(1));
				eachTrans.setAmount(res.getInt(2));
				eachTrans.setType(res.getString(3));
				eachTrans.setUsername(res.getString(4));
				eachTrans.setUniqueTransID(res.getInt(5));
			
				tList.add(eachTrans);
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(cusList);
		return tList;
	}
	
	//Method for customer to view their balance
	public int viewbalance() {
		try {
			String x = "select * from customer where username=?";
			pstmt=con.prepareStatement(x);
			pstmt.setString(1, customerUN);
			System.out.println(customerUN);
			res=pstmt.executeQuery();
			if(res.next()==true) {
				balance=res.getInt(6);
				return 1;
			}
			else {
				return 0;
			}
//			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	public int sendMoney() {
		try {
			//Codes for transferer
			String x = "select * from customer where username=?";
			pstmt=con.prepareStatement(x);
			pstmt.setString(1, customerUN);
			System.out.println("customerUN: "+customerUN);
			uniqueTransID=generateNum(1000,9999);
			System.out.println(uniqueTransID);
			res=pstmt.executeQuery();
			// generating random number here
			if(res.next()==true) {
				//Transferer codes
				if(encrypt(customerPW).equals(res.getString(4))){
					int ogSenderBal=res.getInt(6);
					if(transAmt<=res.getInt(6)) {
						int debitNewBal=res.getInt(6)-transAmt;
						String y = "update customer set balance=? where username=?";
						pstmt=con.prepareStatement(y);
						pstmt.setInt(1, debitNewBal);
						pstmt.setString(2, customerUN);
						int rows=pstmt.executeUpdate();
						
						String addDebitTransaction="insert into transaction values(?,?,?,?,?)";
						pstmt=con.prepareStatement(addDebitTransaction);
						pstmt.setInt(1, transID);
						pstmt.setInt(2, transAmt);
						//To determine if type is credit or debit
						if(ogSenderBal>debitNewBal) {
							System.out.println("oldbalance: "+ogSenderBal+" debitNewBal: "+debitNewBal);
							transType="Debit";
							System.out.println("Transtype: "+transType);
							pstmt.setString(3, transType);
							pstmt.setString(4, customerUN);
							pstmt.setInt(5, uniqueTransID);
							//include random number here
							pstmt.executeUpdate();
						}
						
						
						
						//Recipient codes
						String z = "select * from customer where username=?";
						pstmt=con.prepareStatement(z);
						pstmt.setString(1, recipientUN);
						System.out.println("recipientUN: "+recipientUN);
						res=pstmt.executeQuery();
						if(res.next()==true) {
							int ogRecevierBal = res.getInt(6);
							int creditNewBal=res.getInt(6)+transAmt;
							String z1 = "update customer set balance=? where username=?";
							pstmt=con.prepareStatement(z1);
							pstmt.setInt(1, creditNewBal);
							pstmt.setString(2, recipientUN);
							int rows2=pstmt.executeUpdate();
							String addCreditTransaction="insert into transaction values(?,?,?,?,?)";
							pstmt=con.prepareStatement(addCreditTransaction);
							pstmt.setInt(1, transID);
							pstmt.setInt(2, transAmt);
							if(ogRecevierBal<creditNewBal) {
								System.out.println("oldRecevierbalance: "+ogRecevierBal+" creditNewbal: "+creditNewBal);
								transType="Credit";
								System.out.println("Transtype: "+transType);
								pstmt.setString(3, transType);
								pstmt.setString(4, recipientUN);
								pstmt.setInt(5, uniqueTransID);
								pstmt.executeUpdate();
								return 1;
							}
							
						}else {
							System.out.println("No such recipient username");
							return -2;
						}
					}else {
						System.out.println("transAmt too high");
						return -3;
					}
			
				}else {
					System.out.println("Wrong PW");
					return -1;
				}
			}
			else {
				System.out.println("session did not capture customerUN");
				return 0;
			}
		}
		catch(Exception e) {
			
		}
		return 0;
	}
	//Method to apply loan
	public int applyLoan() {
		try {
			//Reading Balance from customer to verify
			String y = "select * from customer where username=?";
			pstmt=con.prepareStatement(y);
			pstmt.setString(1, customerUN);
			System.out.println("customerUN from session: "+customerUN);
			res=pstmt.executeQuery();
			if(res.next()==true) {
				int loanCeiling = res.getInt(6)*6;
				System.out.println("LoanAmt: "+loanAmt);
				System.out.println("ceiling: "+loanCeiling);
				
				if(loanAmt<loanCeiling) {
					if(res.getInt(8)!=1) {
						//Inserting into loan table
						String x = "insert into loan values(?,?,?,?,?)";
						pstmt=con.prepareStatement(x);
						pstmt.setInt(1, loanID);
						pstmt.setString(2, customerUN);
						pstmt.setString(3, loanType);
						pstmt.setInt(4, loanAmt);
						pstmt.setString(5, loanStatus);
						pstmt.executeUpdate();
						return 1;
						
						
					}else {
						System.out.println("You can't apply for a loan with an active loan");
						return 0;
					}
				}else {System.out.println("Loan amt too high");
				return -1;}
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for admin to view customer list
	public ArrayList<CustomerList> viewCustomerList(){
		ArrayList<CustomerList> cusList=new ArrayList<CustomerList>();
		try {
			String y = "select * from customer";
			pstmt=con.prepareStatement(y);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				CustomerList eachCustomer=new CustomerList();
				eachCustomer.setId(res.getInt(1));
				
				System.out.println(res.getInt(1));
				eachCustomer.setName(res.getString(2));
				System.out.println(res.getString(2));
				eachCustomer.setUsername(res.getString(3));
				System.out.println(res.getString(3));
				eachCustomer.setPassword(res.getString(4));
				System.out.println(res.getString(4));
				eachCustomer.setEmail(res.getString(5));
				System.out.println(res.getString(5));
				eachCustomer.setBalance(res.getInt(6));
				System.out.println(res.getString(6));
				eachCustomer.setSecA(res.getString(7));
				System.out.println(res.getString(7));
				eachCustomer.setActiveLoan(res.getInt(8));
				System.out.println(res.getInt(8));
				cusList.add(eachCustomer);
				
				
//				System.out.println("From model: "+cusList.toString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(cusList);
		return cusList;
	}
	
	//Method for admin to view loans
	public ArrayList<LoanList> viewLoans(){
		ArrayList<LoanList> lList=new ArrayList<LoanList>();
		try {
			String y = "select * from loan";
			pstmt=con.prepareStatement(y);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				LoanList eachLoan=new LoanList();
				eachLoan.setId(res.getInt(1));
				eachLoan.setUsername(res.getString(2));
				eachLoan.setLoan_type(res.getString(3));
				eachLoan.setAmount(res.getInt(4));
				eachLoan.setStatus(res.getString(5));
			
				lList.add(eachLoan);
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(cusList);
		return lList;
	}
	
	//Method for admin to view transaction
	public ArrayList<TransList> viewTransaction(){
		ArrayList<TransList> tList=new ArrayList<TransList>();
		try {
			String y = "select * from transaction";
			pstmt=con.prepareStatement(y);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				TransList eachTrans=new TransList();
				eachTrans.setId(res.getInt(1));
				eachTrans.setAmount(res.getInt(2));
				eachTrans.setType(res.getString(3));
				eachTrans.setUsername(res.getString(4));
				eachTrans.setUniqueTransID(res.getInt(5));
			
				tList.add(eachTrans);
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(cusList);
		return tList;
	}
	
	//Method for admin to filter transaction by unique ID
	public ArrayList<TransList> filteredTransaction(){
		ArrayList<TransList> tList=new ArrayList<TransList>();
		try {
			String y = "select * from transaction where unique_id=?";
			pstmt=con.prepareStatement(y);
			pstmt.setInt(1, filterID);
			System.out.println("filterID from model: "+filterID);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				TransList eachTrans=new TransList();
				eachTrans.setId(res.getInt(1));
				eachTrans.setAmount(res.getInt(2));
				eachTrans.setType(res.getString(3));
				eachTrans.setUsername(res.getString(4));
				eachTrans.setUniqueTransID(res.getInt(5));
			
				tList.add(eachTrans);
				
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(cusList);
		return tList;
	}
	
	//Method for admin to approve loan
	public int approveLoans() {
		try {
			String w = "select * from loan where id=?";
			pstmt=con.prepareStatement(w);
			pstmt.setInt(1, loanID);
			System.out.println("loanID: "+loanID);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				loanUN=res.getString(2);
				System.out.println("loanUN from loan read: "+loanUN);
				loanType=res.getString(3);
				loanAmt=res.getInt(4);
				loanStatus=res.getString(5);
				
				String x = "select * from customer where username=?";
				pstmt=con.prepareStatement(x);
				System.out.println("loanUN from cus read: "+loanUN);
				pstmt.setString(1, loanUN);	
				res=pstmt.executeQuery();
				while(res.next()==true) {
					if(res.getInt(8)!=1) {
						//updating loan tables upon approval
						String y = "update loan set status=? where id=?";
						pstmt=con.prepareStatement(y);
						pstmt.setString(1, "Approved");
						pstmt.setInt(2, loanID);
						int rows=pstmt.executeUpdate();
						System.out.println(rows);
						System.out.println("rows: "+rows);
						System.out.println("loanID: "+loanID);
						//updating customer table upon approval
						String z = "update customer set active_loan=? where username=?";
						pstmt=con.prepareStatement(z);
						pstmt.setInt(1, 1);
						pstmt.setString(2, loanUN);
						pstmt.executeUpdate();
						System.out.println("loanUN from updating cus: "+loanUN);
						return rows;
					}else {
						System.out.println("you cant approve someone with active loans");
						return 0;}
				}
					
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for admin to reject loan
	public int rejectLoans() {
		try {
//			String x = "update loan set status=? where id=?";
//			pstmt=con.prepareStatement(x);
//			pstmt.setString(1, "Rejected");
//			pstmt.setInt(2, loanID);
//			int rows=pstmt.executeUpdate();
//			System.out.println("rows: "+rows);
//			System.out.println("loanID: "+loanID);
//			return rows;
			
			String w = "select * from loan where id=?";
			pstmt=con.prepareStatement(w);
			pstmt.setInt(1, loanID);
			System.out.println("loanID: "+loanID);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				loanUN=res.getString(2);
				System.out.println("loanUN from loan read: "+loanUN);
				loanType=res.getString(3);
				loanAmt=res.getInt(4);
				loanStatus=res.getString(5);
				
				String x = "select * from customer where username=?";
				pstmt=con.prepareStatement(x);
				System.out.println("loanUN from cus read: "+loanUN);
				pstmt.setString(1, loanUN);	
				res=pstmt.executeQuery();
				while(res.next()==true) {
					if(res.getInt(8)!=0) {
						//updating loan tables upon approval
						String y = "update loan set status=? where id=?";
						pstmt=con.prepareStatement(y);
						pstmt.setString(1, "Rejected");
						pstmt.setInt(2, loanID);
						int rows=pstmt.executeUpdate();
						System.out.println(rows);
						System.out.println("rows: "+rows);
						System.out.println("loanID: "+loanID);
						//updating customer table upon approval
						String z = "update customer set active_loan=? where username=?";
						pstmt=con.prepareStatement(z);
						pstmt.setInt(1, 0);
						pstmt.setString(2, loanUN);
						pstmt.executeUpdate();
						System.out.println("You have rejected: "+loanUN);
						return rows;
					}else {
						System.out.println("you cant approve someone with active loans");
						return 0;}
				}
					
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for admin to delete customer
	public int AdDeleteCus() {
		try {
			String x = "delete from customer where id =?";
			pstmt=con.prepareStatement(x);
			pstmt.setInt(1,customerID);
			int rows = pstmt.executeUpdate();
			System.out.println("rows: "+rows);
			System.out.println("customerID: "+customerID);
			return rows;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for admin to edit customer part 1 - read
	public int AdEditCus() {
		try {
			String x = "select * from customer where id =?";
			pstmt=con.prepareStatement(x);
			pstmt.setInt(1,customerID);
			res = pstmt.executeQuery();
			System.out.println("res: "+res);
			System.out.println("customerID: "+customerID);
			if(res.next()!=false) {
				// Assigning value to variables for controller to m.get
				 customerID=res.getInt(1);
				 name = res.getString(2);
				 customerUN = res.getString(3);
				 customerPW = res.getString(4);
				 customerEmail = res.getString(5);
				 balance = res.getInt(6);
				 secA=res.getString(7);
				return 1;
			}
			else {
				return 0;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for admin to edit customer part 2 - edit
	
	public int AdEditCus2() {
		try {
			String y = "select * from customer where id=?";
			pstmt=con.prepareStatement(y);
			pstmt.setInt(1,customerID);
			res = pstmt.executeQuery();
			if(res.next()==true) {
				if(customerID==res.getInt(1)){}
				String x = "update customer set id=?, name=?,username=?,password=?,email=?,balance=?,security_answer=? where id=?";
				pstmt=con.prepareStatement(x);
				pstmt.setInt(1, customerID);
				pstmt.setString(2, newName);
				pstmt.setString(3, newUN);
				pstmt.setString(4, encrypt(newPW));
				pstmt.setString(5, newEmail);
				pstmt.setInt(6, newBalance);
				pstmt.setString(7, secA);
				pstmt.setInt(8, customerID);
				int rows=pstmt.executeUpdate();
				System.out.println("rows: "+rows);
				System.out.println("id: "+newID+"name: "+newName+"newUN: "+newUN+"newPW: "+newPW+" email: "+newEmail+"newBalance: "+newBalance);
				
				return rows;
			}else {
				return 0;
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	//Method for admin to delete transaction
	public int adDeleteTrans() {
		try {
			//adding in select so that I can assign variable
			String y = "select * from transaction where id=?";
			pstmt=con.prepareStatement(y);
			pstmt.setInt(1, transID);
			res=pstmt.executeQuery();
			if(res.next()==true) {
				 transID=res.getInt(1);
				 transAmt = res.getInt(2);
				 transType = res.getString(3);
				 customerUN = res.getString(4);
			}
					
			String x = "delete from transaction where id =?";
			pstmt=con.prepareStatement(x);
			pstmt.setInt(1,transID);
			int rows = pstmt.executeUpdate();
			System.out.println("rows: "+rows);
			System.out.println("transID: "+transID);
			return rows;
		}
		catch(Exception e){
			e.printStackTrace();
		}return 0;
	}
	
	//Method for forget password
	public int scatterBrain() {
		try {
			String y = "select * from customer where username=?";
			pstmt=con.prepareStatement(y);
			pstmt.setString(1, customerUN);
			res=pstmt.executeQuery();
			if(res.next()==true) {
				if(secA.equals(res.getString(7))) {
					System.out.println("secA: "+secA+" resgetstrin(7) "+res.getString(7));
					name=res.getString(2);
					System.out.println("name: "+name+" resgetstrin(2) "+res.getString(2));
					customerUN=res.getString(3);
					System.out.println("customerUN: "+customerUN+" resgetstrin(3) "+res.getString(3));
					secA=res.getString(7);
					return 1;
				}else {
					return -1;
				}
			}else {
				return 0;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	
	
	//Basic PW encryption
	 public String encrypt(String password) {
		 int length=password.length();
		 char securePW[] = password.toCharArray();
		 for(int i=0; i<length;i++) {
			 securePW[i]=(char) (securePW[i]+i);
		 }
		 System.out.println(Arrays.toString(securePW));
		 String s = new String(securePW);
		 return s;
	 }
	 
	 //Basic random number generate
	 public static int generateNum (int min, int max) {
		 
		 int randomNumber = ( int )( Math.random() * max );
		 if( randomNumber <= min ) {
		     randomNumber = randomNumber + min;
		 }
		 return randomNumber;
		 }
	
}

	

	

