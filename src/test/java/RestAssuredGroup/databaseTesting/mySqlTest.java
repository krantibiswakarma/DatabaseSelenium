package RestAssuredGroup.databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class mySqlTest {
  @Test
  public void connectDatabase() {
	  
	  Connection conn = null;
	  
	  String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "myDatabase";
	  String username = "root";
	  String password = "root";
	  
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url+dbName, username, password);
		//String sqlQuery = "select * from employees";
		//String sqlQuery = "select * from employees limit 3";
		String sqlQuery = "select distinct * from employees inner join personal on employees.id=personal.id order by employees.id DESC limit 2";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sqlQuery);
		
		result.next();
		System.out.println("ID: "+result.getString("id"));
		System.out.println("Lastname: "+result.getString("lastName"));
		System.out.println("FirstName: "+result.getString("firstName"));
		System.out.println("Email: "+result.getString("email"));
		System.out.println("City: "+result.getString("city"));
		System.out.println("State: "+result.getString("state"));
		System.out.println("Country: "+result.getString("country"));
		result.next();
		System.out.println("ID: "+result.getString("id"));
		System.out.println("Lastname: "+result.getString("lastName"));
		System.out.println("FirstName: "+result.getString("firstName"));
		System.out.println("Email: "+result.getString("email"));
		System.out.println("City: "+result.getString("city"));
		System.out.println("State: "+result.getString("state"));
		System.out.println("Country: "+result.getString("country"));
	} catch (Exception e) {
		e.printStackTrace();
	}
	 finally{
		 if (conn!=null){
			 conn=null;
	 }
		 
	 }
  }
}
