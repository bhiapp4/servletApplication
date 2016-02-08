package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Browser ->HttpRequest -> SC -> HttpServletRequest, HttpServletResponse -> spawns a thread and asssocuate the HSR, HSR and call the doget method
//S-> HttpServletResponse -> SC -> HttpResponse -> Browser
//Servlets are singleton in nature

//servlet life cycle ->constructor, init method(one present), service method, destory method
//init, destroy and constructor gets called only once
//when does a servlet get instanitiated = during the first request to that servlet
public class GoodByeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	//private int count;//not thread safe
	
	public void init(){
		System.out.println("initailizing the servlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = getServletContext().getInitParameter("email");
		getServletContext().setInitParameter("test1", "test1Val");
		System.out.println(email);
		PrintWriter out = resp.getWriter();
		out.println("Good Bye");
	}

}
