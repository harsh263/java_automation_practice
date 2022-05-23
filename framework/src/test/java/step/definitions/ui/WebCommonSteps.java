package step.definitions.ui;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import driver.manager.BrowserDriverManager;
import page.objects.HomePage;
import page.objects.LoginPage;
import page.objects.RegistrationPage;
import utilities.PropertyFileHandler;

public class WebCommonSteps {
	
	private static Logger logger = Logger.getLogger(WebCommonSteps.class);
	private HomePage homepage;
	private LoginPage loginpage;
	private RegistrationPage regpage;
	private WebDriver driver;
	
			
	@Given("^Perform Login with standard test user$")
	public void perform_Login_with_standard_test_user() throws Throwable {
		try {
		driver = BrowserDriverManager.getdriver();
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		regpage = new RegistrationPage(driver);
		
		homepage.navigate_to_login_page();
		Reporter.addStepLog("Navigated to login page.");
		loginpage.fill_and_submit_log_in_form(PropertyFileHandler.getApplicationPropertty("test_mail_id"), PropertyFileHandler.getApplicationPropertty("common_password"));
		if(!homepage.verify_successful_login()) {
			
			Reporter.addStepLog("Standard user does not exists, Need to register.");
			loginpage.click_on_registration_link();
			regpage.fill_standard_test_user_mail_id();
			regpage.fill_registration_form_and_submit();
			Reporter.addStepLog("Register and login with standard test user.");
			loginpage.fill_and_submit_log_in_form(PropertyFileHandler.getApplicationPropertty("test_mail_id"), PropertyFileHandler.getApplicationPropertty("common_password"));
		}
		Assert.assertTrue(homepage.verify_successful_login());
		}
		catch (Exception e) {
			logger.debug("Stake trace of exception" + e.getStackTrace());
			Reporter.addStepLog("Exception occurred while Login with standard test user.");
			Assert.fail();
		}
	}
	
}
