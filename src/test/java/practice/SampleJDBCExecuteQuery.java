package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
//		step 1: register the driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
//		step-2 Get connection with database - provide DB name
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		
//		step-3 issue create statement
		Statement state=con.createStatement();
		
//		step 4 Execute a query - provide table name
		ResultSet result = state.executeQuery("select * from employeeinfo where id=3;");
		
		while(result.next())
		{
			System.out.println(result.getString(2)+" "+result.getString(3));
		}
		
//		close the database
		con.close();
		
	}
}
