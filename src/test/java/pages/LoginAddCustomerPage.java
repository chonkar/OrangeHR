package pages;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import basePackage.ConfigReader;
import basePackage.DriverFactory;

public class LoginAddCustomerPage {
	//protected WebDriver driver;
	/*
	 * DriverFactory driverfactory=new DriverFactory(); WebDriver driver=
	 * driverfactory.getDriver();
	 */
	
	//DriverFactory driverfactory=new DriverFactory();
	private WebDriver driver;
	private ConfigReader configreader = new ConfigReader();
	private By UserID = By.xpath("//input[@id='user-name']");
	private By Password = By.xpath("//input[@id='password']");
	private By Loginbutton = By.xpath("//input[@id='login-button']");
	//public WebDriver driver=driverfactory.getDriver();;
	

	// SoftAssert softAssert=new SoftAssert();

	public LoginAddCustomerPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	
	 public String geturl() {
	 
	  configreader = new ConfigReader(); 
	  String url = configreader.initialiseProperties("URL"); driver.get(url);
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
	  return url;
	 }

	
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public void EnterUserID_and_Password(String userID, String password) throws InterruptedException {
		/* WebDriverWait wait= new WebDriverWait(driver,20); */
		// wait.until(ExpectedConditions.elementToBeClickable(UserID));
		driver.findElement(UserID).sendKeys(userID);
		System.out.println("Entered UserID");

		// wait.until(ExpectedConditions.elementToBeClickable(Password));
		driver.findElement(Password).sendKeys(password);
		System.out.println("Entered Password");

	}

	public void ClickLoginButton() {
		driver.findElement(Loginbutton).click();
		System.out.println("Clicked on Login button");

	}

	public String getHomePageTitle() throws InterruptedException {
		String Title = driver.getTitle();
		// softAssert.assertEquals(Title, "ManagerDashboard");
		System.out.println("Sucessfully LoggedIn to the Application");

		return driver.getTitle();
	}

}
