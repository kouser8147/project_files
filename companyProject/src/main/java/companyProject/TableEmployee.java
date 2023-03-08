package companyProject;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TableEmployee {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		
		Statement st=con.createStatement();
		st.execute("create table employee(id integer,name varchar(20),designation varchar(15),salary integer)");
		System.out.println("table created");
		
		con.close();
	}

}
			