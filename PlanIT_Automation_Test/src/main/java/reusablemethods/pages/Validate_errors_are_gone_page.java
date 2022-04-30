package reusablemethods.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusablemethods.base.TestBase;

public class Validate_errors_are_gone_page {
	
	
	
	@FindBy(xpath ="//a[contains(@class,'primary')]")
	
	public static WebElement submit;
	
	@FindBy(id="forename")
	
	public static WebElement namep;
	
	@FindBy(id ="email")
	
	public static WebElement emailid;
	
	@FindBy(name ="message")
	
	public  WebElement messagee;
	

    public Validate_errors_are_gone_page(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	
	
	

}
    
    public void clickSubmitt() {
    	
   
    	submit.click();
    	
    }
    
    public void mandetoryFields() {
    	
    	namep.sendKeys(TestBase.property.getProperty("name"));
    	emailid.sendKeys(TestBase.property.getProperty("email"));
    	messagee.sendKeys(TestBase.property.getProperty("message"));
    	
    	
    }
    
   
    }
