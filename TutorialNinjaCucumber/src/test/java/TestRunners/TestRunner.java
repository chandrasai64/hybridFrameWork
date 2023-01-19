package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "StepDefinition", "hooks" }
                       , publish=true
                       ,plugin = {"pretty","html:target/CucumberReport/CucumberReport.html"})
public class TestRunner {
	

}
//plugin={"html:target/CucumberReport.html"}//

//pretty