package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.employee.entity.Employee;

public class EmployeeDAO {

	public Connection connToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1043", "root", "root");
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public int add(Employee emp) {
		Connection c = connToDB();
		try {
			PreparedStatement s = c.prepareStatement("insert into employee (firstname, middlename, lastname, dob, gender, maritalstatus, education, email, mobno, address, password) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			s.setString(1, emp.getFirstName());
			s.setString(2, emp.getMiddleName());
			s.setString(3, emp.getLastName());
			s.setDate(4, emp.getDob());
			s.setString(5, emp.getGender());
			s.setString(6, emp.getMaritalStatus());
			s.setString(7, emp.getEducation());
			s.setString(8, emp.getEmail());
			s.setString(9, emp.getMobNo());
			s.setString(10, emp.getAddress());
			s.setString(11, emp.getPassword());
			
			return s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
}
}
