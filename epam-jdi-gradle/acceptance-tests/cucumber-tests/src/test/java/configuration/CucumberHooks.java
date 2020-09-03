package configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.springBddProject.qa.gui.configuration.WebDriverConfig;
import org.springBddProject.qa.gui.services.webdriver.WrappedWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;


@CucumberContextConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class CucumberHooks {

    @Autowired
    @Lazy
    protected WrappedWebDriver driver;

    @Autowired
    @Lazy
    protected WebDriverConfig driverConfig;

    @Before
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = driverConfig.webDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
    }

    @After
    public void closeDriver() {
        driver.close();
    }

}
