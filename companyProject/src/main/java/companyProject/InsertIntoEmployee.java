package companyProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoEmployee {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		
		Statement st=con.createStatement();

		st.execute("insert into employee values(11,'heena','engineer',100000)");
		st.execute("insert into employee values(12,'Athik','java dev',150000)");
		st.execute("insert into employee values(13,'shab','teacher',25000)");
		st.execute("insert into employee values(14,'rubeena','developer',120000)");
		st.execute("insert into employee values(15,'kouser','software engr',200000)");
		System.out.println("inerted....");
	}

}
