package Employe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/subform")
public class EmployeD extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Servlet is working");
		
		String ename = req.getParameter("Ename");
		String eemail = req.getParameter("Eemail");
		String epass = req.getParameter("Epassword");
		String enumber = req.getParameter("Ephone");
		int phoneno = Integer.parseInt(enumber);
		
		
		System.out.println(ename);
		System.out.println(eemail);
		System.out.println(epass);
		System.out.println(phoneno);
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>"+ename+"</h1>");
		out.println("<h1>"+eemail+"</h1>");
		out.println("<h1>"+epass+"</h1>");
		out.println("<h1>"+phoneno+"</h1>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/myown","root","Chetan@123");
			PreparedStatement ps = c.prepareStatement("insert into myown (Ename,Eemail,Epassword,Ephone)values(?,?,?,?)");
			
			ps.setString(1, ename);
			ps.setString(2, eemail);
			ps.setString(3, epass);
			ps.setInt(4, phoneno);
			ps.executeUpdate();
			c.close();
			
			}
		catch(Exception e)
		{
			e.fillInStackTrace();
			e.getMessage();
		}

	}

}
