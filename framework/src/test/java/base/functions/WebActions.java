package base.functions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.manager.BrowserDriverManager;
import utilities.PropertyFileHandler;

public class WebActions {
	
	private static Logger logger = Logger.getLogger(WebActions.class);
	private WebDriver driver;
	
	public WebActions() throws IOException {
		driver = BrowserDriverManager.getdriver();
	}
	
	public void open_application() {
		try {
		driver.get(PropertyFileHandler.getApplicationPropertty("base_url"));
		}
		catch (Exception e) {
			logger.debug("Not able to read base_url from properties file. Received exception: " + e);
		}
	}
	
	public void click_on_element(WebElement element) {
		element.click();
	}
	
	public void input_text_in_element(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public void select_choice_from_dropdown(WebElement element, String choice) {
		element.click();
		List<WebElement> list_choices = driver.findElements(By.tagName("mat-option"));
		Map<String, WebElement> element_map = new HashMap<String, WebElement>();
		for (WebElement webElement : list_choices) {
			element_map.put(webElement.getText(), webElement);
		}
		element_map.get(choice).click();
	}
	
	public String get_element_text(WebElement element) {
		return element.getText();
	}
	
	public boolean visibility_of_element(WebElement element) {
		return element.isDisplayed();
	}
	
	public Integer number_of_elements(String css_locator) {
		
		return driver.findElements(By.xpath(css_locator)).size();
	}

}
