package generic_utility.interactionUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * This class has all the generic methods related to Actions class
 * @author HP
 *
 */
public class InteractionUtility
{
	private Actions act;
/**
 * This initialize the interaction utility
 * @param driver
 */
	public InteractionUtility(WebDriver driver)
	{
		act=new Actions(driver);
	}
     /**
      * This method is used to do right click action
      */
//     public void rightClick()
// 	{
// 		act.contextClick().perform();
// 	}
     /**
      * This method is used to right click on the Element
      * @param element
      */
     public void rightClick(WebElement element)
  	{
  		act.contextClick(element).perform();
  	}   
     /**
      * This method is used to double click on the Element
      * @param element
      */
     public void doubleclick(WebElement element)
 	{
 		act.doubleClick(element).perform();
 	}
     /**
      * This method is used for mouseover action on the Element
      * @param element
      */
     public void mouseover(WebElement element)
 	{
 		act.moveToElement(element).perform();
 	}
     /**
      * This method is used for pageUp action
      */
     public void pageUp()
 	{
 		act.keyDown(Keys.PAGE_UP).perform();
 	}
     /**
      * This method is used for pageDown action
      */
     public void pagDown()
  	{
  		act.keyDown(Keys.PAGE_DOWN).perform();
  	}
     /**
      * This method is used for Enter action
      */
     public void Enter()
  	{
  		act.keyDown(Keys.ENTER).perform();
  	}
     /**
      * This method is used for drag and drop of the element
      */
     public void dragDrop(WebElement sourceElement,WebElement targetElement)
   	{
   		act.dragAndDrop(sourceElement, targetElement).perform();
   	}
       
}
//give ex for method overloading in interview