package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class InspectionManagerHomePage {
    

	private WebDriver driver;

	private By DashboardTab=By.xpath("//span[contains(text(),'Dashboard')]");
	private By StatusTableHeader=By.xpath("//th[@id='b19-ShiftStatusId']");
	private By RequestIdTableHeader=By.xpath("//th[@id='b19-RequestId']");
	private By ShiftDateTableHeader=By.xpath("//th[@id='b19-StartDate']");
	private By TrustTableHeader=By.xpath("//th[@id='b19-Trust']");
	private By StaffGroupTableHeader=By.xpath("//th[@id='b19-StaffGroup']");
	private By StaffTableHeader=By.xpath("//th[@id='b19-Staff_']");
	private By ActualCostTableHeader=By.xpath("//th[@id='b19-ActualCost']");
	private By BasicTableHeader=By.xpath("//th[@id='b19-Basic']");
	private By NightTableHeader=By.xpath("//th[@id='b19-Night']");
	private By SatTableHeader=By.xpath("//th[@id='b19-Saturday']");
	private By SunTableHeader=By.xpath("//th[@id='b19-Sunday']");
	private By PublicHolidayTableHeader=By.xpath("//th[@id='b19-PublicHoliday']");
	private By ActualHoursTableHeader=By.xpath("//th[@id='b19-ActualHours']");
	private By WardTableHeader=By.xpath("//th[@id='b19-Ward']");
	private By BookedGradeTableHeader=By.xpath("//th[@id='b19-BookedGrade']");
	private By FinalizedDateTableHeader=By.xpath("//th[@id='b19-FinalizedDateHeader']");
	private By AgencyTableHeader=By.xpath("//th[@id='b19-AgencyName']");
	private By ActualStartTableHeader=By.xpath("//th[@id='b19-StartTime']");
	private By ActualBreakTableHeader=By.xpath("//th[@id='b19-Break']");
	private By ActualEndTableHeader=By.xpath("//th[@id='b19-EndTime']");
	private By AssignedToTableHeader=By.xpath("//th[@id='b19-Assignedto']");
	
		
	SoftAssert softAssert=new SoftAssert();
	
	public InspectionManagerHomePage(WebDriver driver) {
		this.driver = driver;
			
	}
	
	public void checkTableHeaderonDashboard() {
		String TableHeader=driver.findElement(StatusTableHeader).getText();
		softAssert.assertEquals("Status", TableHeader);
		String RequestId=driver.findElement(RequestIdTableHeader).getText();
		softAssert.assertEquals("Request ID", RequestId);	
		String ShiftDate=driver.findElement(ShiftDateTableHeader).getText().trim();
		softAssert.assertEquals("Shift Date", ShiftDate);	
		String TrustTable=driver.findElement(TrustTableHeader).getText().trim();
		softAssert.assertEquals("Trust", TrustTable);
		String StaffGroup=driver.findElement(StaffGroupTableHeader).getText().trim();
		softAssert.assertEquals("Staff Group", TrustTable);
		String Staff=driver.findElement(StaffTableHeader).getText().trim();
		softAssert.assertEquals("Staff", TrustTable);
		String ActualCostTable=driver.findElement(StaffTableHeader).getText().trim();
		softAssert.assertEquals("Staff", TrustTable);
		
	}
	
	
}
	