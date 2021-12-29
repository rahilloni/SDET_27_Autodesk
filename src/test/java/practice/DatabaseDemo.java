package practice;

import java.sql.SQLException;

import com.vtiger.comcast.genericUtility.DataBaseUtility;

public class DatabaseDemo {
	
	public static void main(String[] args) throws SQLException {
		
		DataBaseUtility dlib=new DataBaseUtility();
		dlib.connectToDatabase();
		
		dlib.closeDatabase();
		
		
	}

}
