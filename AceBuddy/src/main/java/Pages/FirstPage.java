package Pages;

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

@WebServlet("/submit1")
public class FirstPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ename = req.getParameter("fullname");
		String eemail = req.getParameter("email");
		String epass = req.getParameter("password");
		String enumber = req.getParameter("Ephone");
		int phoneno = Integer.parseInt(enumber);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/myown", "root", "Chetan@123");
			PreparedStatement ps = c.prepareStatement("insert into myown(Ename, Eemail, Epassword, Ephone) values (?, ?, ?, ?)");
			ps.setString(1, ename);
			ps.setString(2, eemail);
			ps.setString(3, epass);
			ps.setInt(4, phoneno);

			int set = ps.executeUpdate();

			if (set > 0) {

				resp.sendRedirect("login.html");
			} else {
				out.print("<h1>Registration Unsuccessful...</h1>");
			}
			c.close();
		} catch (Exception e) {
			out.print("<h1>Error: " + e.getMessage() + "</h1>");
		}
	}
}
