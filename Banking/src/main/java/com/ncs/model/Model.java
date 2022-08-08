package com.ncs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
	private String adminUsername;
	private String adminPassword;
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
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
	public Model() {
		
		try {
			//Driver loading
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NCSBanking","root","Toxofan91");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public int verify() {
		try {
			String s = "Select * from Admin where username=?";
		pstmt= con.prepareStatement(s);
		pstmt.setString(1,adminUsername);
		res=pstmt.executeQuery();
		if(res.next()==true){
			if(adminPassword.equals(res.getString(3))){
				return 1;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
}
