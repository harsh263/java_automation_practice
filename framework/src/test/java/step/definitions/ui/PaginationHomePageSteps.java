package step.definitions.ui;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.manager.BrowserDriverManager;
import page.objects.HomePage;

public class PaginationHomePageSteps {

	private static Logger logger = Logger.getLogger(PaginationHomePageSteps.class);
	HomePage homepage;
	WebDriver driver;
	
	@When("^change product pagination option$")
	public void change_product_pagination_option() throws Throwable {
		driver = BrowserDriverManager.getdriver();
		homepage = new HomePage(driver);
		try {
		homepage.change_pagination_value();
		Reporter.addStepLog("Product pagination dropdown value is updated to 36.");
		}
		catch (Exception e) {
			logger.debug("Exception occurred while changing pagination value of product dropdown: " + e);
			Reporter.addStepLog("Not able to change pagination value of product dropdown.");
			Assert.fail();
		}
		
	}

	@Then("^verify number of product cards on first page$")
	public void verify_number_of_product_cards_on_first_page() throws Throwable {
		try {
		Integer cards = homepage.verify_number_of_visible_products();
		Assert.assertEquals("35", cards.toString());
		Reporter.addStepLog("Number of product cards on Homepage verified successfully.");
		}
		catch (Exception e) {
			logger.debug("Exception occurred while verifying number of product cards:" + e);
			Reporter.addStepLog("Not able to get number of product cards on Homepage.");
			Assert.fail();
		}
	}

}
