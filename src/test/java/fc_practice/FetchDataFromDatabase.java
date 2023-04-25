package fc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
	
public static void main(String[] args) throws SQLException {
//	Step1:- Create instance for driver--> register driver to JDBC
//	import Driver from CJ.sql
	Driver dbDriver=new Driver();
	DriverManager.registerDriver(dbDriver);
	Connection connection=null;
try{//	Step2- get connection-->url, un, pwd-->jdbc:mysql://localhost:3306/mydb
	connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	
//	Step-3--> Create statement
	Statement statement = connection.createStatement();

	
//	Step4---> Execute query
	ResultSet result = statement.executeQuery("select * from project");

//	Step5----> iterate data and verify
//	while(result.next()) {
//		String empName=result.getString("emp_name");
//		int empID 
//	}
	while(result.next()) {
		
		String projectName = result.getString("Project_name");
		System.out.println(projectName);
	}
}finally {
	connection.close();
}
}
}
