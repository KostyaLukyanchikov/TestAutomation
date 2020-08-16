package selenuim.cases.сase2.steps;

import org.openqa.selenium.WebDriver;
import page.objects.DifferentElementsPage;
import page.objects.HomePage;

public abstract class BaseSteps {

    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }


}
