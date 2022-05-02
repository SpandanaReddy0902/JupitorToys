package automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import reusablemethods.base.TestBase;
import reusablemethods.pages.Homepage_to_Contactpage;
import reusablemethods.pages.Verify_items_page;

public class Verify_itemsincart extends TestBase {

	@Test
	public void verifyItemsinCart() {

		test = extent.createTest("verifyItemsinCart");

		String funnyCowItems = "2";
		String fluffyBunnyItems = "1";

		// Navigating to Contact page from Home page

		Homepage_to_Contactpage hc = new Homepage_to_Contactpage(driver);
		hc.contactPage();

		// Adding items to the cart

		Verify_items_page vi = new Verify_items_page(driver);
		vi.itemsVerify();
		vi.cartVerify();

		// validating the items in cart

		String funnyCowCart = driver.findElement(By.xpath("//*[contains(.,'Funny Cow')]//td/input[@value='2']")).getAttribute("value");
		String fluffyBunnyCart = driver.findElement(By.xpath("//*[contains(.,'Fluffy Bunny')]//td/input[@value='1']")).getAttribute("value");
		assertEquals(funnyCowCart, funnyCowItems);
		assertEquals(fluffyBunnyCart, fluffyBunnyItems);

	}
}
