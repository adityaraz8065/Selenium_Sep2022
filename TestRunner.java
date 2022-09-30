package stepdefi;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"Feature Files"},
		glue={"stepdefi"},
		plugin = {"html:target/Report.html" },
		//dryRun = true
		//plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" }
		//plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber", "json:target/cucumber.json" },
		
	    tags= "@Regression and @Sanity"

		)

public class TestRunner extends AbstractTestNGCucumberTests  
{

}
