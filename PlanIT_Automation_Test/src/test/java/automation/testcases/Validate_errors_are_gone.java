package automation.testcases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import reusablemethods.base.TestBase;
import reusablemethods.pages.Homepage_to_Contactpage;
import reusablemethods.pages.Validate_errors_are_gone_page;

public class Validate_errors_are_gone extends TestBase {

	@Test (priority=1)
	public void validateErrors() throws Exception {
		//test = extent.createTest("validateErrors");
		String messageError = "Message is required";
		String forenameError = "Forename is required";
		String emailError = "Email is required";
		Boolean notDisplayed = false;

		// Navigating to contact page
		//WebDriver driver=new ChromeDriver();

		Homepage_to_Contactpage hc = new Homepage_to_Contactpage(driver);
		Thread.sleep(2000);
		hc.contactPage();
	
		// Submitting the form in contact page without any data

		Validate_errors_are_gone_page ve = new Validate_errors_are_gone_page(driver);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		ve.clickSubmitt();

		// checking forename error message is displayed

		String forname = driver.findElement(By.xpath("//span[@id='forename-err']")).getText();
		assertEquals(forname, forenameError);

		// checking email error message is displayed

		String email = driver.findElement(By.xpath("//span[@id='email-err']")).getText();
		assertEquals(email, emailError);

		// checking message error message is displayed

		String message = driver.findElement(By.xpath("//span[@id='message-err']")).getText();
		assertEquals(message, messageError);

		// Populating mandetory fields in the contact page

		ve.mandetoryFields();

		// Verifing the error messages are not present

		Boolean fornamePresent = driver.getPageSource().contains(forenameError);
		assertEquals(fornamePresent, notDisplayed);

		Boolean emailPresent = driver.getPageSource().contains(emailError);
		assertEquals(emailPresent, notDisplayed);

		Boolean messagePresent = driver.getPageSource().contains(messageError);
		assertEquals(messagePresent, notDisplayed);

	}

}
