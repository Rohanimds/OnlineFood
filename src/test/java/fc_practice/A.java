package fc_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
	
	
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("chrome://downloads/");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement we = (WebElement)js.executeScript("return document.querySelector(\"downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"cr-toolbar\").shadowRoot.querySelector(\"cr-toolbar-search-field\")");

	
	List<WebElement> ele = driver.findElements(By.xpath("//a"));
	
	for(WebElement linkele:ele) {
		System.out.println(linkele.getAttribute("href"));
	}
//	System.out.println(linkele.);
	System.out.println(we.getAttribute("id"));
}
}