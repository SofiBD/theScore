package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"summary","pretty","html:target/cucumber-reports.html",
                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        tags = "@AutomatedTests",
        monochrome = true
)

public class MyTestRunner {


}
