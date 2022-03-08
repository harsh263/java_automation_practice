package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import driver.manager.BrowserDriverManager;

public class WebUtilities {

		public void take_screenshot_of_browser(String screenshot_name) throws Exception {
			
			screenshot_name = screenshot_name.replace(" ", "_");
			
			TakesScreenshot scrnshot = ((TakesScreenshot)BrowserDriverManager.getdriver());
			File srcfile = scrnshot.getScreenshotAs(OutputType.FILE);
			File destfile = new File(System.getProperty("user.dir") + File.separator + PropertyFileHandler.getApplicationPropertty("screenshot_path") + 
								File.separator + System.currentTimeMillis() + "_" + screenshot_name + ".png");
			Files.copy(srcfile, destfile);
		}
}
