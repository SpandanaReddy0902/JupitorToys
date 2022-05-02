 package reusablemethods.base;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static  Properties property;
	public  WebDriver driver=null;	
	//public TestBase testbase=null;
	public  ExtentReports extent;
	public ExtentSparkReporter sparkreporter;
	public ExtentTest test;
	

	public static  void loadConfigproperty() {

		try {
			File f = new File(".\\src\\main\\java\\reusablemethods\\Configure\\Config.properties");
			FileReader fr = new FileReader(f);
			property = new Properties();
			property.load(fr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

	public static  String getConfig(String Key)

	{
		loadConfigproperty();
		String value = property.getProperty(Key);
		return value;
	}
	
	
	@BeforeSuite
	public void setExtent() {
		
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/PlanitExtentReports.html");
		sparkreporter.config().setDocumentTitle("JupiterToys");
		sparkreporter.config().setReportName("PlanItTestCases");
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
	}
	
	
	
	@AfterSuite
	public void setDown() {
		
		extent.flush();
	}
	
	
	@BeforeClass
	public  void configBrowser() {


		WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		
		String navigateURL = TestBase.getConfig("url");
		driver.get(navigateURL);
	}

	@AfterClass
	public void closeBrowser(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    
		driver.quit();
		
	}
	
	

}
