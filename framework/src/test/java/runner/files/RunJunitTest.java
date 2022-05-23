package runner.files;



import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.vimalselvam.cucumber.listener.*;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utilities.LoggerConfig;
import utilities.PropertyFileHandler;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFiles",
glue = "step.definitions",
tags = "@ui_regression", 
plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/report.html"})
		
public class RunJunitTest {	
	
	private static Logger logger = Logger.getLogger(RunJunitTest.class);
	
	@BeforeClass
	public static void test_suite_setup() {
		
		LoggerConfig.loadLog4jXmlConfigFile();
	}
	
	@AfterClass
	public static void test_suite_tear_down() {
		logger.debug("This is the After class method of Junit test runner.");
		try {
			String extent_report_config_path =  System.getProperty("user.dir") + File.separator + PropertyFileHandler.getApplicationPropertty("reportConfigPath");
			Reporter.loadXMLConfig(new File(extent_report_config_path));
		} catch (IOException e) {
			logger.debug("Exception occured while reading reportconfigpath from properties file." + e);
			e.printStackTrace();
		}
	}
}