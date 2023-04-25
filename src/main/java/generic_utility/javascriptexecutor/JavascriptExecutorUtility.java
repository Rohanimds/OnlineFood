package generic_utility.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This class has all the generic methods related to javascript executor
 * @author HP
 *
 */
public class JavascriptExecutorUtility
{
	JavascriptExecutor js;
	/**
	 * Initialization of JavaScriptExecutorUtility
	 * @param driver
	 */
	public JavascriptExecutorUtility(WebDriver driver)
	{
		 js = (JavascriptExecutor)driver;
	}
	
	/**
	 * This method is used to scrollUp
	 */
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	/**
	 * This method is used to scrollDown
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method is used to click the element
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()",element);
	}
	
	/**
	 * This method is used to send keys on the selected element
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	
	/**
	 * This method is used to scroll till particular element
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoview()",element); 
	}
	
	/**
	 * This method is used to launchApplication using JavaScript
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]",url);		
	}
	/**
	 * setAttribute  --->>>>  we are highlighting element with the help of this
	 * style   -->>>> Is a css inbuilt method  
	 * border: dashed red;  ---->>>> we will search this syntax in chrome browser as css border copy paste the code
	 * @param element
	 */
	public void highlight(WebElement element)
	{
		js.executeScript("arguments[0].setAttribute('style','border: dashed red;');",element);	
		             
	}
	 
	/**
	 * This method is used to 
	 */
	public void refreshPage()
	{
		js.executeScript("history.go(0)");
	}
	public void getInnerTextOfWebpage()
	{
		System.out.println(js.executeScript("return document.documentElement.innerText;").toString());
	}
	
	public void getTitleOfWebPage()
	{	
		System.out.println(js.executeScript("return document.title;").toString());            
	}
	public void checkbox()
	{	
		js.executeScript("document.getElementById('enter element id').checked=false;");             
	}
	public void getUrlOfThePage()
	{	
	  System.out.println(js.executeScript("return document.URL;").toString());    
	}
	/*public void getHeightofWebpage()
	{	
		 js.executeScript("return window.innerHeight;").toString();
		 js.executeScript("return window.innerWidth;").toString();
		    
	}*/
	
	
}

