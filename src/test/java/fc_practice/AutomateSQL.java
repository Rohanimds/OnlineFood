package fc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateSQL {
	public static void main(String[] args) throws SQLException {
		WebDriverManager.chromedriver().setup();

		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Random r=new Random();
		int rannum = r.nextInt(1000);
		driver.get("http://rmgtestingserver:8084");
		String loginTitle = driver.getTitle();
		if(loginTitle.equals("React App")) {
			System.out.println("In React App page succesfull");
		}else {
			System.out.println("In React App page fail");
		}
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.urlContains("welcome"));
		String welcomeurl = driver.getCurrentUrl();
		System.out.println(welcomeurl);
		if(welcomeurl.contains("welcome")) {
			System.out.println("In welcome page succesfull");
		}else {
			System.out.println("In welcome page fail");
		}

		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		String projecturl = driver.getCurrentUrl();
		if(projecturl.contains("projects")){
			System.out.println("In projects page succesfull");
		}else {
			System.out.println("In projects page succesfull");
		}
		String pName = "Confidential"+rannum;
		String createdBy = "boss"+rannum;
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(pName);
		driver.findElement(By.name("createdBy")).sendKeys(createdBy);
		WebElement dropdown = driver.findElement(By.name("status"));

		String value = "Created";
		Select s=new Select(dropdown);
		s.selectByValue(value);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		String alt = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		System.out.println(alt);
		if(alt.contains("Successfuly")) {
			System.out.println("Project Created Successfully");
		}else {
			System.out.println("Project Created failed");
		}
		InsertDataIntoDatabase.validateInDatabase(pName,createdBy,value);
		}
}
