package fc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondScenario {
public static void main(String[] args) throws SQLException {
	    
	   
		
		//Step1:create instance and register to databasemanager
			Driver dbDriver=new Driver();
			DriverManager.registerDriver(dbDriver);
			Connection	connection=null;
			
			//String manager="raju";
			//String projectName="selenium";
			//String projectId="ty13";
			//String status="planning";
			//String createdOndate="7/2/2023";
			//String teamSize="10";
		
			try {
	    //Step2:connect to jdbc
			 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");//rmg databse connection
			
		//Step3:create statement
			
		 Statement statement=connection.createStatement();
			
	    //Step4:execuet Query
	        
	        //	int result =statement.executeUpdate("insert into project values(projectId,manager,createdOndate,projectName,status,teamSize)");
			//Random r=Random();
			//int rannum = r.nextInt(99);
		//	String pID = "ty"+rannum;
			
			int result =statement.executeUpdate("insert into project values('ty17','rohan','7/2/2023','selenium','planning',10)");
			
			
			if(result==1)
			{
				System.out.println("data added sucessfully");
			}
			}
			finally {
				connection.close();
				System.out.println("connection closed");
			} 
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			String un="rmgyantra";
		    String pwd="rmgy@9999";	
		    String projectid="ty17";
			driver.get(" http://rmgtestingserver:8084");
			String titileRmg = driver.getTitle();
			if(titileRmg.equals("React APP"))
			{
				System.out.println("rmg welcome page displayed");
			}
			driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			driver.findElement(By.xpath("//a[text()='Projects']")).click();
			List<WebElement> list= driver.findElements(By.xpath("//th[text()='ProjectId']/../../following-sibling::tbody/tr/td[1]"));
			for(WebElement ele:list)
			{
				String text = ele.getText();
				if(text.equals(projectid))
				{
					System.out.println(projectid+" present in rmg Ui");
					break;
				}
			}
			
		  
		 }

}

