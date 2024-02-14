package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class EntityInformationPage {

	private WebDriver driver;

	
	private By LableCreateCase=By.xpath("//div[@id='b14-MainContent']//span[contains(text(),'Create Case')]");
	private By LableEntityName=By.xpath("//span[contains(text(),'Entity Name')]");
	private By EnterEntityName=By.xpath("//input[@id='Input_TextVar2']");
	private By checkCheckBox=By.xpath("//input[@type='checkbox']");
	private By clickOnCancelButton=By.xpath("//button[contains(text(),'Cancel')]");
	private By ClickOnNextButton=By.xpath("//span[contains(text(),'Next')]");
	private By typeofInspection=By.xpath("//select[@id='b18-b4-Dropdown1']");
	private By SelectStartDate=By.xpath("//div[@id='b18-b6-Icon']");
	private By selectDate=By.xpath("//span[@aria-label='January 9, 2024']");
	private By selectInspector=By.xpath("//span[contains(text(),'Kavita C')]");
	private By selectPreInspectionChecklistCheckbox=By.xpath("//input[@id='b18-b11-Checkbox2']");
	private By SubmitButton=By.xpath("//span[contains(text(),'Submit')]");
	SoftAssert softAssert=new SoftAssert();
	
	
	public EntityInformationPage(WebDriver driver) {
		this.driver = driver;
			
	}
	

	public void checkCreateCaseLable() {
		String caseLable=driver.findElement(LableCreateCase).getText();
		softAssert.assertEquals(caseLable, "Create Case");

	}
	
	public void checkEntityNameLable() {
		String entityLable=driver.findElement(LableEntityName).getText();
		softAssert.assertEquals(entityLable,"Entity Name");
	}
	
	public void enterEntityName() throws InterruptedException {
		driver.findElement(EnterEntityName).sendKeys("Dominos");
		Thread.sleep(5000);
	}
	
	public void checkCheckbox() {
		driver.findElement(checkCheckBox).click();
	}
	
	public void clickonCancelButton() {
		driver.findElement(clickOnCancelButton).click();
	}
	
	public void clickOnNextButton() {
		driver.findElement(ClickOnNextButton).click();
	}
	
	public void selectTypeofInspection() {
		driver.findElement(typeofInspection).click();
		Select select=new Select(driver.findElement(typeofInspection));
		select.selectByVisibleText("Food Inspection");
	}
	
	public void selectDatefromCalendar() {
		driver.findElement(SelectStartDate).click();
		driver.findElement(selectDate).click();
	}
	
	public void selectInspector() {
		driver.findElement(selectInspector).click();
	}
	
	public void selectPreInspectionChecklist() {
		driver.findElement(selectPreInspectionChecklistCheckbox).click();
	}
	
	public void clickOnSubmitButton() {
		driver.findElement(SubmitButton).click();
	}
}

	
