package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepDefinitions"},
        plugin = { "pretty", "json:target/cucumber-html-report/cucumber-report.json",
                   "junit:target/cucumber-html-report/cucumber-report.xml",
                   "html:target/cucumber-html-report/cucumber-report.html"},
        monochrome = true)
public class TestRunner {
}
