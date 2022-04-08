package reusablemethods.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethods.base.TestBase;

public class Validate_errors_invalid_data_page {
	
	
	@FindBy(id="forename")
	public static WebElement namee;
	
	@FindBy(id="email")
	public static WebElement mailiid;
	
	@FindBy(id="message")
	public static WebElement messageee;
	
	public Validate_errors_invalid_data_page(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	}
	
	
	public void invalidData() {
		
		
		mailiid.sendKeys(TestBase.property.getProperty("invalidemail"));
		
	}

}
