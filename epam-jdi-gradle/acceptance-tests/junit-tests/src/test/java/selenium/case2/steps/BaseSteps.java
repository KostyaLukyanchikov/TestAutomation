package selenium.case2.steps;

import configuration.AppConfig;
import org.openqa.selenium.WebDriver;
import org.springBddProject.qa.gui.services.pages.voids.DifferentElementsPage;
import org.springBddProject.qa.gui.services.pages.voids.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;


@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public abstract class BaseSteps {
    @Autowired
    @Lazy
    protected WebDriver driver;

    @Autowired
    @Lazy
    protected HomePage homePage;

    @Autowired
    @Lazy
    protected DifferentElementsPage differentElementsPage;
}
