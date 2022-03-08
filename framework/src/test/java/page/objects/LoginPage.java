package page.objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.functions.WebActions;

public class LoginPage {

	WebActions action;
	WebDriver driver;
	
	@FindBy(css = "#newCustomerLink > a")
	private WebElement registration_page_link;
	@FindBy(css = "#email")
	private WebElement input_email;
	@FindBy(css = "#password")
	private WebElement input_password;
	@FindBy(css = "#loginButton")
	private WebElement submit_login;
	
	public LoginPage(WebDriver d) throws IOException {
		this.driver = d;
		action = new WebActions();
		PageFactory.initElements(d, this);
	}
	
	public void click_on_registration_link() throws IOException {
		action.click_on_element(registration_page_link);
	}
	
	public void fill_and_submit_log_in_form(String email, String password) {
		action.input_text_in_element(input_email, email);
		action.input_text_in_element(input_password, password);
		action.click_on_element(submit_login);
	}
}
