package com.abc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Model 
{
	private String name;
	private String custid;
	private int accno;
	private int bal;
	private String email;;
	private String pass;
	private int raccno;
	
	private Connection con=null;
	PreparedStatement pstmt = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	
	public int getRaccno() {
		return raccno;
	}
	public void setRaccno(int raccno) {
		this.raccno = raccno;
	}

	public Model() throws Exception
	{
		DriverManager.registerDriver(new Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root");
		System.out.println("loading driver and establishing connection is completed");
	}
	
	public boolean register() throws Exception 
	{
		pstmt = con.prepareStatement("INSERT INTO ABCBANK VALUES(?,?,?,?,?,?)");
		pstmt.setString(1, name);
		pstmt.setString(2, custid);
		pstmt.setInt(3, accno);
		pstmt.setString(4, pass);
		pstmt.setInt(5, bal);
		pstmt.setString(6, email);
		
		int x = pstmt.executeUpdate();
		System.out.println(x);
		if(x>0)
		{
			return true;
		}
		return false;
	}
	public boolean login() throws SQLException 
	{
		String s = "select * from abcbank where cust_id=? and password=?";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1, custid);
		pstmt.setString(2, pass);
		
		ResultSet res = pstmt.executeQuery();
		
		while(res.next()==true)
		{
			accno = res.getInt("accno");
			return true;
		}
		return false;
	}
}
