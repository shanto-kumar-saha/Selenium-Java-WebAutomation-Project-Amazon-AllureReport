package allure_reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class AllureReporting {
	
	private static final SeverityLevel SeverityLevel = null;
	static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shant\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Test(description = "This test case helps me validating the title of the page")
	@Description("This test case helps me validating the title of the page")

	@Story("[JIRA-1235] This story checks the basic elements of the web page")
	@Feature("Validate title")
	
	public void validateTitle() {
		
		
		Assert.assertEquals(getPageTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");		
	}
	

	
	@Test
	@Description("This test case helps me validating the title of the page")

	@Story("[JIRA-1235] This story checks the basic elements of the web page")
	@Feature("Sign In link")
	
	
	public void verifyLogo()
	{
	boolean flag = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
	Assert.assertTrue(flag);
	}
	//public void validateSignInLink() {
		//WebElement SignInLink = driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span[1]"));
		//Assert.assertTrue(isElementAndTextPresent(SignInLink,"Hello. Sign in"),"Sign In link is not present in the page");}
		
	
	
	@Step("Validating if element{0} is displayed on page with text{1}")
	public boolean isElementAndTextPresent(WebElement element, String value) {
		return element.isDisplayed() && element.getText().equalsIgnoreCase(value) ;
		
	}
	
	@Step("feteching the title of the page")
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	}


