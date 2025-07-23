package com.employee.service;


import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;

public class EmployeeService {
	public boolean add(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		int rowsAffected = dao.add(emp);

		if (rowsAffected > 0) {
			return true;
		} else {
			return false;
		}
	}
}
