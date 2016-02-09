package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Get request - appends information to the URL
//2KB is size limit for limit
//Get requests are used to get something from the server
//Post request - as a part of request body
//no size limit
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		System.out.println(req.getParameter("userName"));
		System.out.println(req.getParameter("password"));	
		PrintWriter out = resp.getWriter();
		//out.println("received " +req.getParameter("userName") + " password " + req.getParameter("password"));
		if ("bh".equals(req.getParameter("password"))){
			//cookie
			Cookie cookie = new Cookie("uname",req.getParameter("userName"));
			//associate cookie to the response
			resp.addCookie(cookie);			
			HttpSession session = req.getSession();
			session.setAttribute("uname", req.getParameter("userName"));
			req.getRequestDispatcher("register.html").forward(req, resp);
		}
		else{
			out.println("Please check your user name and password");
			req.getRequestDispatcher("login.html").include(req, resp);			
		}
	}
}
