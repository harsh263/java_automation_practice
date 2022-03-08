package step.definitions.ui;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import base.functions.WebActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.manager.BrowserDriverManager;
import page.objects.HomePage;
import page.objects.LoginPage;
import page.objects.RegistrationPage;
import utilities.PropertyFileHandler;

public class RegistrationSteps {

	private static Logger logger = Logger.getLogger(RegistrationSteps.class);
	private static WebDriver driver;
	private WebActions actions;
	private HomePage homepage;
	private LoginPage loginpage;
	private RegistrationPage regpage;
	private String random_email;
	
	@Given("^Open browser and Home page of website$")
	public void create_browser_instance_and_base_url(){
		try {
		driver = BrowserDriverManager.getdriver();
		actions = new WebActions();
		actions.open_application();
		Reporter.addStepLog("Browser driver instance is created successfully.");
		}
		catch (Exception e) {
			logger.debug("Not able to create a driver instance. Exception received as: " + e);
			Reporter.addStepLog("Exception occurred while creating webdriver instance" + e);
			Assert.fail();
		}		
	}
	
	@Given("^Accept cookies and welcome message$")
	public void accept_cookie_consent_welcome_message(){
		try {
			homepage = new HomePage(driver);
			homepage.accept_cookie_consent_and_welcome_message();
			Reporter.addStepLog("Welcomessage pop-up and cookie consent is dismissed.");
		} catch (Exception e) {
			logger.debug("Stack trace of exception: " + e.getStackTrace());
			Reporter.addStepLog("Exception occurred while accepting welcome and cookie message.");
			Assert.fail();
		}
	}
	

	@When("^Navigate to Login page$")
	public void user_navigate_to_login_page(){
		try {
			homepage.navigate_to_login_page();
			Reporter.addStepLog("User navigated to Login form page.");
		}
		catch (Exception e) {
			logger.debug("Stake trace of exception: " + e.getStackTrace());
			Reporter.addStepLog("Exception occurred while navigating to Login page.");
			Assert.fail();
		}
			   
	}

	@When("^Navigate to Registration form page$")
	public void navigate_to_registration_page() throws Throwable {
		try {
			loginpage = new LoginPage(driver);
			loginpage.click_on_registration_link();
			Reporter.addStepLog("User navagated to Registration form page.");
		}
		catch (Exception e) {
			logger.debug("Stake trace of exception" + e.getStackTrace());
			Reporter.addStepLog("Exception occurred while navigating to registration page.");
			Assert.fail();
		}
	}
	
	@When("^Fill up Registration form with random data and submit$")
	public void fill_up_Registration_form_with_random_data_and_submit() throws Throwable {
		regpage = new RegistrationPage(driver);
		try {
			random_email = regpage.fill_registration_form_and_submit();
			Reporter.addStepLog("Registration form filled up with random data and submitted.");
		}
		catch (Exception e) {
			logger.debug("Stake trace of exception" + e.getStackTrace());
			Reporter.addStepLog("Exception occurred while filling registration page.");
			Assert.fail();
		}
		
	}

	@Then("^Verify successful Login using new user$")
	public void verify_successful_Login_using_new_user() throws Throwable {
		try {
		loginpage.fill_and_submit_log_in_form(random_email, PropertyFileHandler.getApplicationPropertty("common_password"));
		Assert.assertTrue(homepage.verify_successful_login());
		Reporter.addStepLog("Logged in varification successful with new created user.");
		}
		catch (Exception e) {
			logger.debug("Stake trace of exception" + e.getStackTrace());
			Reporter.addStepLog("Exception occurred while Login with new user.");
			Assert.fail();
		}
	}



	
}