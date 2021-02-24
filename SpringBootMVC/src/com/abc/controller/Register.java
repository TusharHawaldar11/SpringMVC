package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Model;
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String custid = request.getParameter("custid");
		int accno = Integer.parseInt(request.getParameter("accno"));
		int bal =Integer.parseInt(request.getParameter("bal"));
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		try
		{
			Model m = new Model();
			m.setName(name);
			m.setCustid(custid);
			m.setAccno(accno);
			m.setBal(bal);
			m.setEmail(email);
			m.setPass(pass);
			
			
			if(m.register()==true)
			{
				//response.sendRedirect("/SpringBootMVC/SuccessReg.html");
				response.sendRedirect("/BankApplication/SuccessReg.html");
			}
			else
			{
				response.sendRedirect("/BankApplication/FailureReg.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}
