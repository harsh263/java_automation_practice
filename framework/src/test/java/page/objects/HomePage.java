package page.objects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.functions.WebActions;

public class HomePage {
	
	private static Logger logger = Logger.getLogger(HomePage.class);
	
	private WebDriver driver;
	private WebActions action;
	
	@FindBy(css = "button[aria-label=\"Close Welcome Banner\"]")
	private WebElement dismis_welcome_message;
	@FindBy(css = "a[aria-label=\"dismiss cookie message\"]")
	private WebElement accept_cookie_consent;
	@FindBy(css = "#navbarAccount")
	private WebElement account_link;
	@FindBy(css = "#navbarLoginButton")
	private WebElement login_link;
	@FindBy(xpath = "//button//span[text()=' Your Basket']")
	private WebElement your_basket_link;
	@FindBy(css = "#mat-select-0")
	private WebElement drpdwn_product_pagination;
	private String product_cards_xpath = "//mat-grid-list//mat-grid-tile";
	
	public HomePage(WebDriver d) throws IOException {
		this.driver = d;
		action = new WebActions();
		PageFactory.initElements(d, this);
	}
	
	public void accept_cookie_consent_and_welcome_message() {
		action.click_on_element(dismis_welcome_message);
		action.click_on_element(accept_cookie_consent);
	}
	
	public void navigate_to_login_page() {
		action.click_on_element(account_link);
		action.click_on_element(login_link);
	}
	
	public boolean verify_successful_login() throws InterruptedException {
		Thread.sleep(1000);
		if(driver.getCurrentUrl().contains("/#/search")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void change_pagination_value() {
		action.select_choice_from_dropdown(drpdwn_product_pagination, "36");
	}
	
	public Integer verify_number_of_visible_products() {
		Integer visible_cards = action.number_of_elements(product_cards_xpath);
		return visible_cards;
	}
}
