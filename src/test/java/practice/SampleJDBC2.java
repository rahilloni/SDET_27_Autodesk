package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC2 {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bikesdb", "root", "root");
		
		Statement state = con.createStatement();
		
		int result = state.executeUpdate("insert into bikesinfo values(6,'CBR',250,25,170);");
		
		if(result==1)
		{
			System.out.println("succesfully updated");

		}
		
		con.close();
	}

}
