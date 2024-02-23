package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {



	private Properties prop ;
	String fetchedProperty;
	/**
	 * This method is used to load properties from Configuration files
	 */
	public String initialiseProperties(String propertyName) {
		
		prop = new Properties();
		try {
			FileInputStream fileIP = new FileInputStream("D:\\RobotFramework\\Orange HRM Project\\src\\test\\resources\\config\\config.properties");
			prop.load(fileIP);
			fetchedProperty = prop.getProperty(propertyName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fetchedProperty;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
