package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	//redirect = hard redirect = redirection generates a brand new request
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = getServletConfig().getInitParameter("test");
		System.out.println(value);
		PrintWriter out = resp.getWriter();
		out.println("Hello world");
		//forward kills the response from the previous servlet
		//req.getRequestDispatcher("/goodBye").forward(req, resp);
		//req.getRequestDispatcher("/goodBye").include(req, resp);
		resp.sendRedirect("http://www.google.com");
		
	}
}
