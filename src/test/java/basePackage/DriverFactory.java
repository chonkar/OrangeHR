package basePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

public WebDriver driver;
	
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	
	
	
	/**This method is used to initiate the threadlocal driver on the basis of given browser**/
	public WebDriver initiateDriver(String browserName) {
		//Utils utils=new Utils(driver);
		System.out.println("The browser name is : "+browserName );
		
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			threadLocalDriver.set(new ChromeDriver());
		}
		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			threadLocalDriver.set(new FirefoxDriver());
		}
		
		else if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			threadLocalDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("The browser name entered is not correct "+browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return getDriver();
	}
	
	/**this is used to get the driver with ThreadLocal**/
	public static synchronized WebDriver getDriver() {
		return threadLocalDriver.get();
	}

}
