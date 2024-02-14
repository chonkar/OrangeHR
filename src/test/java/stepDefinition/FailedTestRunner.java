package stepDefinition;

import org.testng.annotations.DataProvider;

import basePackage.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
		
features =  "@target1/failed_scenarios.txt",
glue = {"stepDefinition"},
monochrome = true,
plugin  = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
publish=true

 
//dryRun = true	

)		

public class FailedTestRunner extends BaseDriver {
	
	
	@Override
	@DataProvider(parallel = true)	
		 
	public Object [] [] scenarios(){
	return super.scenarios();	
	
	}
}