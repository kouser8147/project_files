package httpServletMiniProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/httplogin")
public class LoginPage extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdatabase","root","root");
		
			PreparedStatement ps=con.prepareStatement("select * from facebookusers where email=? and password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			HttpSession session=req.getSession();
			session.setAttribute("myemail", email);
			
			
			while(rs.next())
			{
				RequestDispatcher rd=req.getRequestDispatcher("homePage.html");
				rd.forward(req, resp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		//PrintWriter pw=resp.getWriter();
		ServletOutputStream pw=resp.getOutputStream();
		pw.print("");
		
		
		pw.print("---------------------------------------------------------------------------------------------------------INCORRECT USERNAME OR PASSWORD--------------------------------------------------------------------------------");
		
		
		RequestDispatcher rd=req.getRequestDispatcher("LoginPage.html");
		rd.include(req, resp);
		
	}
}
