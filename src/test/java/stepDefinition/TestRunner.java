package stepDefinition;

import org.testng.annotations.DataProvider;

import basePackage.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
		
features =  ".\\src\\test\\resources\\features",
glue = {"stepDefinition"},
monochrome = true,
//tags="@Smoke1",
plugin  = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"rerun:target1/failed_scenarios.txt",	
		}
,publish=true
)		

public class TestRunner extends BaseDriver {
	
	
	@Override
	@DataProvider(parallel = false)	
		 
	public Object [] [] scenarios(){
	return super.scenarios();	
	
	}
}