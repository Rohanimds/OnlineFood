package generic_utility.dropdown;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class has all the generic methods related to dropdown
 * @author HP
 *
 */
public class Dropdown {

/**
 * Select class object creation
 * @param ele
 */
	
/**
 * This method is used to select element by text in the dropdown
 * @param text
 */
	public void selectByVisibleText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
/**
 * This method is used to select element by value
 * @param value
 */
	public void selectByValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}
/**
 * This method is used get all the options in the dropdown
 * @return
 */
	public List<WebElement> getAllOptions(WebElement ele) {
		Select s = new Select(ele);
		return s.getOptions();
	}
/**
 * This method is used to deselect all the clicked option in the dropdown
 */
	public void deselectAll(WebElement ele) {
		Select s = new Select(ele);
		if (s.isMultiple())
			s.deselectAll();
	}
/**
 * This method is used to deselect option by value
 * @param value
 */
	public void deselectByValue(WebElement ele,String value) {
		Select s = new Select(ele);
		if (s.isMultiple())
			s.deselectByValue(value);
	}
/**
 * This method is used to deselect option by text
 * @param text
 */
	public void deselectByVisibleText(WebElement ele, String text) {
		Select s = new Select(ele);
		if (s.isMultiple())
			s.deselectByVisibleText(text);
	}
/**
 * This method is used to extract all the selected options in the dropdown
 * @return
 */
	public List<WebElement> getAllSelectedOptions(WebElement ele) {
		Select s = new Select(ele);
		if (s.isMultiple())
			return s.getAllSelectedOptions();
		return null;
	}
}
