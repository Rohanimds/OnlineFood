package generic_utility.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This class has all the generic methods related to database operation
 * @author HP
 *
 */
public class DatabaseOperation {
	/**
	 * this is used to initialize the database
	 */
	void initializeDatabase() {
Connection connection=null;
try {
DriverManager.registerDriver(new Driver());
DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects\",\"root@%\",\"root");
}catch(SQLException e){
	e.printStackTrace();
}
}
}