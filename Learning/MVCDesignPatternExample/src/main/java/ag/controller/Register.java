package ag.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import ag.dbConnection.DBConn;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String pass = req.getParameter("user_pass");

		try {
			Connection con = DBConn.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into register value (?, ?, ?);");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			if (ps.executeUpdate() > 0) {
				out.println("<h3 style='color: green'>Register Done! </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req, resp);
			} else {
				out.println("<h3 style='color: red'>Not Registered! </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/register.html");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
