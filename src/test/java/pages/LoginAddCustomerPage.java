package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class LoginAddCustomerPage {

	private WebDriver driver;

	private By UserID = By.xpath("//input[@id='b2-b3-Input_Username']");
	private By Password = By.xpath("//input[@id='b2-b3-Input_Password']");
	private By Loginbutton = By.xpath("//button[@id='b2-b3-Button_Login']");
	private By ForgetPassword = By.xpath("//span[contains(text(), 'Forgot')]");
	private By termsAndConditions=By.xpath("//input[@id='b2-b3-Checkbox_Disclaimer']");
	private By InvalidErrorMessage= By.xpath("//div[contains(text(),'Invalid')]");
	private By clickonUser=By.xpath("//div[@id='b2-b2-$b2']");
	private By LogOutButton=By.xpath("//span[contains(text(),'Log out')]");
	
	SoftAssert softAssert=new SoftAssert();
	
	
	//Utils utils=new Utils(driver);
	

	public LoginAddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void EnterUserID_and_Password(String userID, String password) throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(UserID));
		driver.findElement(UserID).sendKeys(userID);
		System.out.println("Entered UserID");
		
		wait.until(ExpectedConditions.elementToBeClickable(Password));
		driver.findElement(Password).sendKeys(password);
		System.out.println("Entered Password");
		

	}

	public void ClickLoginButton() throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Loginbutton));
		driver.findElement(Loginbutton).click();
		System.out.println("Clicked on Login button");

	}

	public String getHomePageTitle() throws InterruptedException {
		String Title= driver.getTitle();
		softAssert.assertEquals(Title, "ManagerDashboard");
		System.out.println("Sucessfully LoggedIn to the Application");
		

		return driver.getTitle();
	}

	public String GetCustomerPageTitle() throws InterruptedException {

		return driver.getTitle();

	}
	
	public void verifyErrorMessage() {
		String ErrorMessageonHomePage= driver.findElement(InvalidErrorMessage).getText();
		softAssert.assertEquals(ErrorMessageonHomePage, "Invalid username or password.");
		
	}
	
	public void clickonForgetPasswordLink() {
		driver.findElement(ForgetPassword).click();
	}
	
	public void Termsandconditions() {
		driver.findElement(termsAndConditions).click();
	}
	
	public void LogoutButton() {
		driver.findElement(LogOutButton).click();
	}

	
}
