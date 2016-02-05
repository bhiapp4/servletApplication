package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Get request - appends information to the URL
//2KB is size limit for limit
//Get requests are used to get something from the server
//Post request - as a part of request body
//no size limit
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("userName"));
		System.out.println(req.getParameter("password"));	
		PrintWriter out = resp.getWriter();
		out.println("received " +req.getParameter("userName") + " password " + req.getParameter("password"));
	}
}
