package utilities;

import java.io.File;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerConfig {

	public LoggerConfig() {
	}

	public static void loadLog4jXmlConfigFile() {
		
		DOMConfigurator.configure(System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "java" + File.separator + "configs" + File.separator + "log4j.xml");
	}
}
