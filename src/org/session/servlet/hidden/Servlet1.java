package org.session.servlet.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("welcome " + req.getParameter("userName"));
		StringBuffer sb = new StringBuffer(
				"<form action='servlet2' method='get'> <table> <tr> <td>Name</td> <td><input type='text' name='name'/></td> </tr> "
				+ "<tr> <td>City</td> <td><input type='text' name='city'/></td> </tr> "
				+ "<tr> <td>Street</td> <td><input type='text' name='street'/></td> </tr> "
				+ "<tr> <td>State</td> <td><input type='text' name='state'/></td> </tr> "
				+ "<tr> <td>Country</td> <td> <select name='country'> <option label='United States' value='US'/> <option label='United Kingdom' value='UK'/> </select> </td> </tr> "
				+ "<tr> <td>Zip</td> <td><input type='text' name='zipCode'/></td> </tr> "
				+ "<tr><td><input type='hidden' name='uname' value='"+req.getParameter("userName")+"'></td></tr></table> "
				+ "<input type='submit' value='Register'/> "
				+ "</form>");
		out.println(sb.toString());
	}
}
