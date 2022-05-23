package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class DatePicker {
	
	WebDriver driver = null;

	@Given("^Navigate to date picker page$")
	public void navigate_to_date_picker_page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
	}

	@Given("^Click on date text box$")
	public void click_on_date_text_box() throws Throwable {
		WebElement iframe = driver.findElement(By.xpath("//*[@id='post-2661']/div[2]/div/div/div[1]/p/iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("datepicker")).click();
	}

	@When("^Select the date \"(.*?)\" \"(.*?)\" \"(.*?)\" and click$")
	public void select_the_date_and_click(String expected_date, String expected_month, String expected_year) throws Throwable {
		try {
	    String current_mon = driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > span.ui-datepicker-month")).getText().strip();
	    String current_year = driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > span.ui-datepicker-year")).getText().strip();
	    System.out.println("current values = " + current_mon + current_year);
	    System.out.println("expected values = " + expected_month + expected_year);
	    System.out.println(!stringCompare(current_mon + current_year, expected_month + expected_year));
	    int initial_year = Integer.parseInt(current_year);
		int expected_mon_int = get_month_int(expected_month);
		int actual_month_int = get_month_int(current_mon);
	    while(!stringCompare(current_mon + current_year, expected_month + expected_year)) {
	    	if(initial_year == Integer.parseInt(expected_year)) {
	    		// Get mon to int
	    		if(expected_mon_int < actual_month_int) {
	    			// Click on left arrow
	    			driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-prev.ui-corner-all")).click();
	    		}
	    		else {
	    			// Click on right arrow
	    			driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-next.ui-corner-all")).click();
	    		}
	    	}
	    	else if(initial_year > Integer.parseInt(expected_year)) {
	    		// Click on Left arrow
	    		driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-prev.ui-corner-all")).click();
	    	}
	    	else {
	    		// Click on Right arrow
	    		driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-next.ui-corner-all")).click();
	    	}
	    	current_year = driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > span.ui-datepicker-year")).getText().strip();
	    	current_mon = driver.findElement(By.cssSelector("#ui-datepicker-div > div > div > span.ui-datepicker-month")).getText().strip();
	    }
	    
	    List<WebElement> date_raws = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr"));
	    for (WebElement webElement : date_raws) {
			List<WebElement> date_cell = webElement.findElements(By.tagName("td"));
			for (WebElement date : date_cell) {
				String d = date.getText();
				if(stringCompare(d, expected_date)) {
					date.click();
				}
			}
		}
	    
	    String actual_date = driver.findElement(By.cssSelector("#datepicker")).getText();
//		Assert.assertEquals(actual_date, expected_date + "/" + expected_month + "/" + expected_year);
		}
		catch (Exception e) {
			// TODO: handle exception
			driver.quit();
		}
	    
	}

	@Then("^Validate the selected date$")
	public void validate_the_selected_date() throws Throwable {
		driver.quit();
	}

	
	public static boolean stringCompare(String str1, String str2)
    {
  
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
  
            if (str1_ch != str2_ch) {
                return false;
            }
        }
  
        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return false;
        }
  
        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return true;
        }
    }

	public static int get_month_int(String month) {
		month = month.toLowerCase();
		switch(month) {
		case "january":
			return 1;
		case "february":
			return 2;
		case "march":
			return 3;
		case "april":
			return 4;
		case "may":
			return 5;
		case "june":
			return 6;
		case "july":
			return 7;
		case "auguest":
			return 8;
		case "september":
			return 9;
		case "october":
			return 10;
		case "november":
			return 11;
		case "december":
			return 12;
		default:
			return 0;
		}
	}
}
