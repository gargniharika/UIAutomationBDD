package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/RunCuke/cucumber.json", "pretty", "junit:target/cucumber-reports/report.html"},
        features = "src/test/resources/features",
        glue = "steps",
        monochrome=true,
        tags={"@LoginValidation","@ProductSearch"}
        
        )
public class RunCuke {
	

	}

