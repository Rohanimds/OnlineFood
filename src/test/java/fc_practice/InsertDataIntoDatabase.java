package fc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.javafaker.Faker;
import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {
public static void main(String[] args) {
//	Connection connection=null;
//	try {
//		Driver dbdriver=new Driver();
//		DriverManager.registerDriver(dbdriver);
//		
//		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");
//		
//		Statement statement = connection.createStatement();
//		
//		long empId;
//		String eName;
//		long salary;
//		long phNumber;
//		String address;
//		for(int i=0; i<50; i++) {
//			
//			empId=new Faker().number().randomNumber(4, true);
//			eName="name_"+new Faker().number().randomNumber(4, true);
//			salary=new Faker().number().randomNumber(5, true);
//			phNumber=new Faker().number().randomNumber(10, true);
//			address="address_"+new Faker().number().randomNumber(4, true);
//
//			int row=statement.executeUpdate("insert into Employee values("+empId+")
//		}
//		
//		ResultSet result = statement.executeQuery("select * from employee");
//		
//		while(result.next()) {
//			
//		}
//		
//		
//	}
	
}
  public static void validateInDatabase(String projectName, String createdBy, String status) throws SQLException {
	Connection connection = null;
	try {
		DriverManager.registerDriver(new Driver());
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3333/projects", "root@%", "root");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from project;");
		boolean validated = false;
		while(resultSet.next()){
			if(projectName.equals(resultSet.getString("project_name"))) {
				if(createdBy.equals((resultSet.getString("createdBy"))) && status.equals(resultSet.getString("status"))){
						validated=true;
					}
			break;	
			}
			}
		if(validated) {
			System.out.println("project successfully addrd yodatabase");
		}else {
			System.out.println();
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally{
		connection.close();
	}
	}

}