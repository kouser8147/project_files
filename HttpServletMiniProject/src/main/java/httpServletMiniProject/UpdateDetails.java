package httpServletMiniProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateDetails extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdatabase","root","root");
			
			PreparedStatement ps=con.prepareStatement("select * from facebookusers where email=?");
					ps.setString(1, email);
					
					ResultSet rs=ps.executeQuery();
					
					HttpSession session=req.getSession();
					session.setAttribute("email", email);
					
					while(rs.next())
						{
							RequestDispatcher rd=req.getRequestDispatcher("idFetch.jsp");
							rd.forward(req, resp);
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.print("");
		
		RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
		rd.include(req, resp);
		
	}

}
