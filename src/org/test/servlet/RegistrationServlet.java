package org.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jnit.dao.CustomerDao;
import org.jnit.domain.Customer;

public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerDao custDao = new CustomerDao();
		Customer customer = new Customer();
		customer.setCity(req.getParameter("city"));
		customer.setName(req.getParameter("name"));
		customer.setStreet(req.getParameter("street"));
		customer.setState(req.getParameter("state"));
		customer.setCountry(req.getParameter("country"));
		customer.setZipCode(req.getParameter("zipCode"));
		int noOfRows = custDao.insertCustomer(customer);
		if (noOfRows == 1){
			resp.getWriter().println(customer.getName() + " saved to database");
		}
	}
}
