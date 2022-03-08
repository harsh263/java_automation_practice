package driver.manager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyFileHandler;

public class BrowserDriverManager {
	
	private static WebDriver driver;
	private static Logger logger = Logger.getLogger(BrowserDriverManager.class);
	
	private BrowserDriverManager() {
		
	}
	
	public static WebDriver getdriver() throws IOException {

		if (driver != null) 
		return driver;
		return createwebdriverinstance();
	}
	
	@SuppressWarnings("deprecation")
	private static WebDriver createwebdriverinstance() throws IOException {
		switch(PropertyFileHandler.getApplicationPropertty("browser")) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
		case "opera":
			WebDriverManager.operadriver().setup();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeAllbrowsersessions() {
		
		if(driver != null) {
			driver.close();
			driver = null;
			logger.debug("All web driver instances are closed.");
		}
	}
}
