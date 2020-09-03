package selenium.case1.steps;

import configuration.AppConfig;
import org.springBddProject.qa.gui.services.webdriver.WrappedWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;


@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public abstract class BaseSteps {

    @Autowired
    @Lazy
    public WrappedWebDriver driver;

    @Value("${site.url}")
    protected String epamUrl;

}
