package httpServletMiniProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpnewAccount")
public class CreateNewAccount extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		String gender=req.getParameter("gender");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdatabase","root","root");
			
			PreparedStatement ps=con.prepareStatement("insert into facebookusers values(?,?,?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2, email);
			ps.setLong(3, phone);
			ps.setString(4, gender);
			ps.setString(5, password);
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("LoginPage.html");
		rd.forward(req, resp);
	}
	

}
