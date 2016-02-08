package org.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jnit.dao.CustomerDao;
import org.jnit.domain.Customer;
//Request dispatcher
//include = includes a response from more than one servlet
//forward = forward a request from one servlet to another servlet
public class SearchServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerDao custDao = new CustomerDao();
		List<Customer>customers = custDao.fetchCustomersByCity(req.getParameter("city"));
		//you end up writing html in java
		StringBuffer sb = new StringBuffer("<table border=1>");
		sb.append("<tr><td>CustomerId</td><td>Name</td><td>City</td><td>State</td><td>Country</td></tr>");
		for (Customer customer : customers) {
			sb.append("<tr><td>");
			sb.append(customer.getCustomerId());
			sb.append("</td><td>");
			sb.append(customer.getName());
			sb.append("</td><td>");
			sb.append(customer.getCity());
			sb.append("</td><td>");
			sb.append(customer.getState());
			sb.append("</td><td>");
			sb.append(customer.getCountry());
			sb.append("</td></tr>");
		}
		sb.append("</table>");
		resp.getWriter().println(sb.toString());
	}
}
