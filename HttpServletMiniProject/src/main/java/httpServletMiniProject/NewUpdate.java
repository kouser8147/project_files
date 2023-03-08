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

@WebServlet("/change")
public class NewUpdate extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String password=req.getParameter("password");
		String email=req.getParameter("mail");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdatabase","root","root");
			PreparedStatement ps=con.prepareStatement("update facebookusers set name=?,phone=?,password=? where email=?");
			ps.setString(1, name);
			ps.setLong(2, phone);
			ps.setString(3, password);
			ps.setString(4,email);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("Last.jsp");
		rd.forward(req, resp);
	}
	
}
