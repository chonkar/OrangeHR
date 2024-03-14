package basePackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public class BaseDriver {

	private TestNGCucumberRunner testNGCucumberRunner;
	boolean flag = false;

//protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws IOException, InterruptedException {

		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerup.bat");
		Thread.sleep(2000);
		String file = "output.txt";

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
		long StopTime = cal.getTimeInMillis();

		while (System.currentTimeMillis() < StopTime) {
			if (flag) {
				break;
			}
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String LineRead = bf.readLine();
			while (LineRead != null && !flag) {

				if (LineRead.contains("Node has been added")) {
					System.out.println("Found my Match");
					flag = true;
					break;
				}
				LineRead = bf.readLine();
			}
			bf.close();
		}

		Assert.assertTrue(flag);
		Thread.sleep(3000);

	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerdown.bat");
		Thread.sleep(2000);
		String file = "output.txt";

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
		long StopTime = cal.getTimeInMillis();

		while (System.currentTimeMillis() < StopTime) {
			if (flag) {
				break;
			}
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String LineRead = bf.readLine();
			while (LineRead != null && !flag) {

				if (LineRead.contains("Shutdown complete")) {
					System.out.println("Found my Match");
					flag = true;
					break;
				}
				LineRead = bf.readLine();
			}
			bf.close();
		}

		Assert.assertTrue(flag);
		File f = new File("output.txt");
		if (f.delete()) {
			System.out.println("File Deleted Sucessfully");
		}
		Thread.sleep(3000);
		testNGCucumberRunner.finish();
	}

}
