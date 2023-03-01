package testSuites;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.PercyPage;

public class HomePageTestSuite extends BasePage{

	public HomePage hp;
	public PercyPage pp;
	
	@Test
	public void validatePercyLink() {
		hp = new HomePage(driver);
		waitForElementToBeVisible(hp.productsTab);
		Assert.assertTrue(hp.productsTab.isDisplayed());
		Assert.assertEquals(hp.productsTab.getText(), "Products");
		new Actions(driver).moveToElement(hp.productsTab).perform();
		waitForElementToBeVisible(hp.productsDropdown);
		Assert.assertTrue(hp.productsDropdown.isDisplayed());
		waitForElementToBeVisible(hp.percyLink);
		Assert.assertTrue(hp.percyLink.isDisplayed());
		Assert.assertEquals(hp.percyLink.getAttribute("data-product"), "Percy");
		hp.percyLink.click();
		pp = new PercyPage(driver);
		waitForElementToBeVisible(pp.percyTitle);
		Assert.assertTrue(pp.percyTitle.isDisplayed());
		Assert.assertEquals(pp.percyTitle.getText(), "Percyguigu");
	}
	
	
}
