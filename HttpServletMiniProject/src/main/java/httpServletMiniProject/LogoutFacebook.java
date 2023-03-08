package httpServletMiniProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutfacebook")
public class LogoutFacebook extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("myemail");
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.print("my email is : "+email);
		
		session.invalidate();
		RequestDispatcher rd=req.getRequestDispatcher("LoginPage.html");
		rd.forward(req, resp);
	}
}
