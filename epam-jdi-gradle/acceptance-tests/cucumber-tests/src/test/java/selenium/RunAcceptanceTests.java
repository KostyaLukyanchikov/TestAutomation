package selenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"acceptance-tests/cucumber-tests/src/test/resources"},
        glue = {"classpath:"})
public class RunAcceptanceTests {
}

