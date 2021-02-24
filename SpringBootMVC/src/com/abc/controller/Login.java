package com.abc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String custid = request.getParameter("custid");
		String pass = request.getParameter("pass");
		session = request.getSession(true);
		try
		{
			Model m = new Model();
			m.setCustid(custid);
			m.setPass(pass);
			boolean b = m.login();
			if(b==true)
			{
				session.setAttribute("accno", m.getAccno());
				//response.sendRedirect("/SpringBootMVC/Home.html");
				response.sendRedirect("/BankApplication/Home.html");
			}
			else
			{
				response.sendRedirect("/BankApplication/Error.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
