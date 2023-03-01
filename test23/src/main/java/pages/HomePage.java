package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory, this);
	}
	
	//Navigation bar elements
	@FindBy(css="#product-menu-toggle") public WebElement productsTab;
	@FindBy(css="#developers-menu-toggle") public WebElement developersTab;
	@FindBy(css="[title='Live for Teams']") public WebElement liveForTeamsTab;
	@FindBy(css="[title='Pricing']") public WebElement pricingTab;
	@FindBy(css="[title='Sign In']") public WebElement sigInTab;
	@FindBy(css="[title='Free Trial']") public WebElement freeTrial;
	
	//Products content
	@FindBy(css="#product-menu-dropdown") public WebElement productsDropdown;
	@FindBy(css=".menu-item-percy") public WebElement percyLink;
}
