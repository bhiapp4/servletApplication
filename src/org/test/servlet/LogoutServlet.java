package org.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null){
			session.invalidate();
			req.getRequestDispatcher("login.html").forward(req, resp);
		}
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length > 0){
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);//expiring the cookie
			}
		}
	}
}
