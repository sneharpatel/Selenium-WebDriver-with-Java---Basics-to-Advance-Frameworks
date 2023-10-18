package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// cucumber --> we are using testNG or Junit just to run cucumber runner file only
// other than that everywhere we use cucumber for code implementation

// we use runner file based on assertions we use i.e TestNG assertion and annotations
@CucumberOptions(features = "src/test/java/cucumber", glue=".stepDefination", monochrome = true,
        tags = "@Regression", plugin = {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
