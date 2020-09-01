package selenium.case2.steps;

import org.openqa.selenium.WebDriver;
import org.springBddProject.qa.gui.services.pages.voids.DifferentElementsPage;
import org.springBddProject.qa.gui.services.pages.voids.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


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

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }
}
