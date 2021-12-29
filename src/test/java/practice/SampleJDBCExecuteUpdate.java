package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	
	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
//		register the driver
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root", "root");
		
		//issue create statement 
		Statement state = con.createStatement();
		
		//execute a query
		int result = state.executeUpdate("insert into employeeinfo values(7,'soeed','vijapur');");
		
		if (result==1)
		{
			System.out.println("data addded successfully");
		}
		else {
			System.out.println("error");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			con.close();
			System.out.println("finally block executed");
			
		}
		
		
	}

}
