package fc_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class olympic {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		String cName = "Australia";
		
		//	driver.findElement(By.xpath("//input[@type='radio' and@id='u_4_4_FL']//ancestor::div[@id='u_4_n_mA']//preceding-sibling::div[@id='fullname_field']//descendant::div[@class='placeholder' and text()='Surname']"))
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		String Winner = driver.findElement(By.xpath("//div[@data-cy='table-content']//span[@data-cy='country-name' "
				+ "and text()='"+cName+"']//parent::div//following-sibling::div[2]/span")).getText();
				System.out.println(Winner);
	}
}