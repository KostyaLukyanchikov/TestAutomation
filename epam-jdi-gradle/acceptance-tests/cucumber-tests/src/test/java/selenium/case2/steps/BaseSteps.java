package selenium.case2.steps;

import configuration.AppConfig;
import org.springBddProject.qa.gui.services.enums.LoginUser;
import org.springBddProject.qa.gui.services.pages.voids.DifferentElementsPage;
import org.springBddProject.qa.gui.services.pages.voids.HomePage;
import org.springBddProject.qa.gui.services.webdriver.WrappedWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;


@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public abstract class BaseSteps {

    @Autowired
    @Lazy
    protected WrappedWebDriver driver;

    @Value("${site.url}")
    protected String epamUrl;

    @Value("${diff.el.page.url}")
    protected String diffElPageUrl;

    @Autowired
    @Lazy
    protected HomePage homePage;

    @Autowired
    @Lazy
    protected DifferentElementsPage differentElementsPage;

    protected List<String> getServiceElementsFromHeader() {
        return homePage.grabServiceElementsFromHeader();
    }

    protected List<String> getServiceElementsFromLeftSideBar() {
        return homePage.grabServiceElementsFromLeftSideBar();
    }

    protected int getTheNumberOfCheckBoxesOnDifferentElementsPage() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getCheckBoxes()).size();
    }

    protected int getTheNumberOfRadioButtonsOnDifferentElementsPage() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getRadioButtons()).size();
    }

    protected int getTheNumberOfDropDowns() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getDropDowns()).size();
    }

    protected int getTheNumberOfButtons() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getButtons()).size();
    }

    protected LoginUser userNameEnum(String loginUser) {
        switch (loginUser) {
            case "user":
                return LoginUser.PITER_CHAILOVSKII;
            default:
                return LoginUser.PITER_CHAILOVSKII;
        }
    }

}
