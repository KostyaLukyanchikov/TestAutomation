package configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@CucumberContextConfiguration
@SpringBootTest(classes = {AppConfig.class})
public class CucumberHooks {

    private static int failedTests = 0;
    private static int passedTests = 0;
    private static int count = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberHooks.class);

    @Before
    public void setScenarioInfoIntoLog(Scenario scenario) {
        setIdIntoLog(scenario);
        setScenarioName(scenario);
        //driver = new ChromeDriver();
    }

    @After
    public void logCountOfTest(Scenario scenario) throws IOException {
        count++;
        if (scenario.isFailed()) {
            failedTests++;
        } else {
            passedTests++;
        }
        LOGGER.info("There are {} tests completed.",count);
        LOGGER.info("Status of last test is {}",scenario.getStatus());
        LOGGER.info("Passed tests: {}, Failed test: {}",passedTests, failedTests);
    }


    public void setScenarioName(Scenario scenario) {
        MDC.put("scenarioName", scenario.getName());
    }

    public void setIdIntoLog(Scenario scenario) {
        final Pattern testCaseIdPattern = Pattern.compile("@TestCaseId\\(\"+?([^\"]+)\"+?\\)");
        for (String tag : scenario.getSourceTagNames()) {
            Matcher matcher = testCaseIdPattern.matcher(tag);
            if (matcher.matches()) {
                final String testCaseId = matcher.group(1);
                MDC.put("testCaseId", testCaseId);
            }
        }
    }
}
