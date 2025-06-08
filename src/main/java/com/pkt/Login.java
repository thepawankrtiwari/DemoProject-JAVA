package com.pkt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginuser")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email= req.getParameter("email");
		String password=req.getParameter("password");
	
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		if(email.equals("Yuvi@gmail.com") && password.equals("Yuvi123")){
			System.out.println("Successfully Login..");
			out.print("Successfully Login..");
			
			RequestDispatcher rd= req.getRequestDispatcher("/profile.html");
			rd.forward(req, resp);
			
		}else {
		System.out.println("Invalid Login..");
		out.print("Invalid Login..");
		RequestDispatcher rd= req.getRequestDispatcher("/register.html");
		rd.include(req, resp);
		
		
	}}
}
