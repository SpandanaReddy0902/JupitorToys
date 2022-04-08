package reusablemethods.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_to_Contactpage {
	 
	     @FindBy(xpath = "//a[contains(@href,'contact')]")
		 public  WebElement contact;

		 
		 public  Homepage_to_Contactpage(WebDriver driver) {
				
				PageFactory.initElements(driver, this);		
			
			}
		 
		 public void contactPage() {
			 
			 contact.click();
		 }
		 
	 
			
		 
	       

}
