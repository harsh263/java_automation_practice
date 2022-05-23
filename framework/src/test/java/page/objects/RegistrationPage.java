package page.objects;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.functions.WebActions;
import utilities.PropertyFileHandler;

public class RegistrationPage {

	WebDriver driver;
	WebActions action;
	
	@FindBy(css = "#emailControl")
	private WebElement Input_Emailid;
	@FindBy(css = "#passwordControl")
	private WebElement Input_password;
	@FindBy(css = "#repeatPasswordControl")
	private WebElement Input_confirm_password;
	@FindBy(css = "mat-select")
	private WebElement Drodwn_security_que;
	@FindBy(css = "#securityAnswerControl")
	private WebElement Input_sec_answer;
	@FindBy(css = "#registerButton")
	private WebElement submit;
	
	public RegistrationPage(WebDriver d) throws IOException {
		this.driver = d;
		action = new WebActions();
		PageFactory.initElements(d, this);
	}
	
	public String fill_random_mail_id() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String email_name = salt.toString();
        String random_email = email_name + "@gmail.com";
        action.input_text_in_element(Input_Emailid, random_email);
        return random_email;
	}
	
	public void fill_standard_test_user_mail_id() throws IOException {
		String email_id = PropertyFileHandler.getApplicationPropertty("test_mail_id");
		action.input_text_in_element(Input_Emailid, email_id);
	}
	
	public void fill_registration_form_and_submit() throws IOException {
        action.input_text_in_element(Input_password, PropertyFileHandler.getApplicationPropertty("common_password"));
        action.input_text_in_element(Input_confirm_password, PropertyFileHandler.getApplicationPropertty("common_password"));
        action.select_choice_from_dropdown(Drodwn_security_que, "Mother's maiden name?");
        action.input_text_in_element(Input_sec_answer, "Test Answer");
        action.click_on_element(submit);
	}
}
