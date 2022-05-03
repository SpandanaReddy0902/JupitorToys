package automation.testcases;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import reusablemethods.base.TestBase;
import reusablemethods.pages.Homepage_to_Contactpage;
import reusablemethods.pages.Validate_errors_invalid_data_page;

public class Validate_errors_invalid_data extends TestBase {
	
	@Test (priority=2)
	
	public void invalidDataErrors() {
		//test=extent.createTest("invalidDataErrors");
		Boolean vaildEmail=true;
		
		//Navigating to contact page
		
		Homepage_to_Contactpage hc=new Homepage_to_Contactpage(driver);
		hc.contactPage();
		
		//Populating invalid data to the mandetory fields
		
		Validate_errors_invalid_data_page vei=new Validate_errors_invalid_data_page(driver);
		vei.invalidData();
		
		//Verifying error message is present
		
		Boolean emailvalidation=driver.getPageSource().contains("Please enter a valid email");
		assertEquals(emailvalidation,vaildEmail);
		
		
	}

	
}

