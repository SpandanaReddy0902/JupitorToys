package reusablemethods.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Verify_items_page {
	
	@FindBy(xpath = "//a[contains(@href,'shop')]")
	public  WebElement shop=null;
	
	@FindBy(xpath="//li[contains(.,'Funny Cow')]//a[contains(@class,'btn btn-success')]")
	public  WebElement funnycow=null;
	
	@FindBy(xpath = "//li[contains(.,'Fluffy Bunny')]//a[contains(@class,'btn btn-success')]")
	public  WebElement fluffybunny=null;
	
	@FindBy(xpath = "//i[@class='icon icon-shopping-cart icon-white']")
	public  WebElement cart=null;
	
	public Verify_items_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void itemsVerify() {
		
		shop.click();
		funnycow.click();
		funnycow.click();
		
	}
	public void cartVerify() {
		fluffybunny.click();
		cart.click();
		
	}
	

}
