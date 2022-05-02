package reusablemethods.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablemethods.base.TestBase;

public class Validate_errors_invalid_data_page {
	
	
	@FindBy(id="forename")
	public  WebElement namee=null;
	
	@FindBy(id="email")
	public  WebElement mailiid=null;
	
	@FindBy(id="message")
	public  WebElement messageee=null;
	
	public Validate_errors_invalid_data_page(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	}
	
	
	public void invalidData() {
		
		//TestBase testbase=new TestBase();
		mailiid.sendKeys(TestBase.property.getProperty("invalidemail"));
		
	}

}
