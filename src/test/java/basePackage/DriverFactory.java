package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public ConfigReader configReader;
	//String browserName;
	String url;

	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initiate the threadlocal driver on the basis of given
	 * browser
	 * @throws IOException 
	 **/
	
	public WebDriver initiateDriver(String browserName) throws IOException {
		//WebDriver driver = null;
		/*
		 * browserName = configReader.initialiseProperties("Browser");
		 * url=configReader.initialiseProperties("URL");
		 */
		
		
		
		System.out.println("The browser name is : " + browserName);
		URL u = new URL("http://localhost:4444/");
		URL u1 = new URL("http://localhost:7900/");
		URL u2 = new URL("http://localhost:8081/");

		
			if (browserName.equalsIgnoreCase("Chrome")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");

				// RemoteWebDriver remoteWebDriver = new RemoteWebDriver(u,cap);

				// driver = new RemoteWebDriver(u,options);
				driver = WebDriverManager.chromedriver().remoteAddress(u).create();
				threadLocalDriver.set((RemoteWebDriver) driver);
				
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				// DesiredCapabilities cap=new DesiredCapabilities();
				/*
				 * FirefoxOptions options = new FirefoxOptions();
				 * options.addArguments("--remote-allow-origins=*");
				 */

				driver = WebDriverManager.firefoxdriver().browserInDocker().remoteAddress(u1).create();
				threadLocalDriver.set((RemoteWebDriver) driver);
			}

			else if (browserName.equalsIgnoreCase("Edge")) {
				/*
				 * EdgeOptions options = new EdgeOptions();
				 * options.addArguments("--remote-allow-origins=*");
				 */
				driver = WebDriverManager.edgedriver().browserInDocker().remoteAddress(u2).create();
				threadLocalDriver.set((RemoteWebDriver) driver);
				/*
				 * WebDriverManager.edgedriver().setup(); threadLocalDriver.set(new
				 * EdgeDriver());
				 */
			} else {
				System.out.println("The browser name entered is not correct " + browserName);
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//return driver;
		
		return driver;
	}

	/** this is used to get the driver with ThreadLocal **/
	public synchronized static WebDriver getDriver() {
		return threadLocalDriver.get();
	}


public void quitbrowser() {
		getDriver().quit();
	}
	

	public void getScreenshot(Scenario scenario) throws IOException {
		String screenShotName = scenario.getName().replaceAll(" ", "_");

		File sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		byte[] FileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(FileContent, "image/png", screenShotName);
	}
}
