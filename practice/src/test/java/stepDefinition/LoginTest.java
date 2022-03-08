package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.en.Then;
import java.util.List;


public class LoginTest {
	static WebDriver driver = null;
  @Given("^User is on Home page of website$")
  public void given() throws Throwable {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://juice-shop.herokuapp.com/");
	  driver.findElement(By.cssSelector("button[aria-label=\"Close Welcome Banner\"]")).click();
	  driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();
	  System.out.println("Create chrome browser instance and open base URL.");
  }

  @When("^User click on each product card and close pop-up$")
  public void when() throws Throwable {
	  try {
	  List<WebElement> cards = driver.findElements(By.cssSelector("div > mat-card"));
	  for (WebElement product_card : cards) {
		product_card.click();
		driver.findElement(By.cssSelector("button[aria-label=\"Close Dialog\"]")).click();
	  	} 
	  }
	  catch (Exception e) {
		  System.out.println("Not able to click on some of the products.");
	}
	  
  }

  @Then("^Close the browser$")
  public void then() throws Throwable {
	  driver.quit();
  }
  
  @When("^background test step(\\d+)$")
  public void backgrount_test_step(int arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      System.out.println("We are in Backgroung test " + arg1 + " method");
  }

  @Then("^click on the link$")
  public void click_on_the_link() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
     System.out.println("We are in click on this link Exception.");
  }
  
  @Before
  public void beforeScenario(){
      System.out.println("This will run before the Scenario");
  }	
	
	@After
  public void afterScenario(){
      System.out.println("This will run after the Scenario");
  }

}
