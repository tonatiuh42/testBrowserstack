package pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		openBrowserAndNavigateToUrl();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		driver.quit();
	}
	
	public void openBrowserAndNavigateToUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/");
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver,5);
		wait.ignoring(WebDriverException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(TimeoutException.class);
		wait.pollingEvery(java.time.Duration.ofMillis(300));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
