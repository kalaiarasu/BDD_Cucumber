package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resource/AppFeatures"},
		glue= {"stepDefinitions","apphooks"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/","rerun:rerun.txt"}
	    //tags = "not @skip"
		
		)



public class MyTestRunner {
	


}
