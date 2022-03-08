package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertyFileHandler {
	
	private static Logger logger = Logger.getLogger(PropertyFileHandler.class);
	private static final Properties APPLICATION_PROPERTIES = new Properties();
	
	
	private static final String TEST_PROPERTY_FILE_DIRECTORY = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "properties" + File.separator;
	
	private PropertyFileHandler() {
		
	}
	
	public static String getApplicationPropertty(String propertyName) throws IOException {
		if(APPLICATION_PROPERTIES.isEmpty()) {
		File f = new File(TEST_PROPERTY_FILE_DIRECTORY + "application.properties");
		if(f.exists()) {
			logger.debug("Before load application properties");
			
			try {
				FileInputStream fis = new FileInputStream(f);
				APPLICATION_PROPERTIES.load(fis);
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}	
			}
		else {
			System.out.println("properties is not available.");
			logger.debug("properties file is not available.");
			}
		}
		try {
			return APPLICATION_PROPERTIES.getProperty(propertyName);
		}
		catch (Exception e) {
			logger.debug("Error while reading proerty" + propertyName + "from file: " + e);
			return null;
		}
		
	}
		
}
	
