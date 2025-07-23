package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class AddEmployeeController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee emp = new Employee();
		
		String firstName = req.getParameter("firstname");
		String middleName = req.getParameter("middlename");
		String lastname = req.getParameter("lastname");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String mrStatus = req.getParameter("mrstatus");
		String education = req.getParameter("Qualifications");
		String email = req.getParameter("email");
		String mobNo = req.getParameter("mobno");
		String address = req.getParameter("address");
		String password = req.getParameter("pass");
		
		Date newDob = Date.valueOf(dob);
		
		
		emp.setFirstName(firstName);
		emp.setMiddleName(middleName);
		emp.setLastName(lastname);
		emp.setDob(newDob);
		emp.setGender(gender);
		emp.setMaritalStatus(mrStatus);
		emp.setEducation(education);
		emp.setEmail(email);
		emp.setMobNo(mobNo);
		emp.setAddress(address);
		emp.setPassword(password);
		EmployeeService service = new EmployeeService();
		
		if(service.add(emp)) {
			PrintWriter out = resp.getWriter();
			out.println("<h1> "+"Registraion Successfull"+ " </h1>");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.forward(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.println("<h1> "+"Registraion Failed"+ " </h1>");
			req.getRequestDispatcher("Registration.html").forward(req, resp);
		}

		
	}
}
