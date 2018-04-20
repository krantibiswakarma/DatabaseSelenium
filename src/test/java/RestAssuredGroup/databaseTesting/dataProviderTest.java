package RestAssuredGroup.databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
	@Test(dataProvider = "dp")
	public void f(String id, String ln, String fn, String em) {
		System.out.println("id: " +id);
		System.out.println("ln: " +ln);
		System.out.println("fn: " +fn);
		System.out.println("em: " +em);
	}

	@DataProvider
	public Object[][] dp() throws Exception {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String databaseName = "myDatabase";
		String username = "root";
		String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url + databaseName, username, password);
			String query = "Select * from employees";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			result.next();
			Object[][] data ={{result.getString("id"),result.getString("lastname"), result.getString("firstname"), result.getString("email")}};
			/*System.out.println("ID: "+result.getString("id"));
			System.out.println("Lastname: "+result.getString("lastName"));
			System.out.println("FirstName: "+result.getString("firstName"));
			System.out.println("Email: "+result.getString("email"));*/
			return data;
	}
}