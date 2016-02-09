package org.session.servlet.hidden;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		if (null == uname){
			resp.setContentType("text/html");
			resp.getWriter().println("Please login first");
			req.getRequestDispatcher("servlet1login.html").forward(req, resp);
		}else{
			//database persistence..
		}
	}
}
