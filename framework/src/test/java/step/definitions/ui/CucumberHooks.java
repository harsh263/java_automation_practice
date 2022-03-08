package step.definitions.ui;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import driver.manager.BrowserDriverManager;
import utilities.WebUtilities;

public class CucumberHooks {

	WebUtilities webutils = new WebUtilities();
	@After(order = 1)
	public void tear_down() {
		BrowserDriverManager.closeAllbrowsersessions();
	}
	
	@After(order = 0)
	public void take_screenshot_for_failed(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			webutils.take_screenshot_of_browser("failed_step_" + scenario.getName());
		}
	}
	
}
