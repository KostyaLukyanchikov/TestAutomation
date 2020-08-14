package сase2.steps;

import entities.User;
import enums.Header.HeaderElements;
import enums.Header.HeaderServiceElements;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;

public abstract class BaseSteps {

    private WebDriver driver;
    private HomePage homePage;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }


    public void loginAsUser(User user) {
        homePage.login(user);
    }

    public void openServiceDropDownMenu() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
    }

    public void navigateToDifferentElementsPage() {
        homePage.headerOpenServiceDropDown(HeaderServiceElements.DIFFERENT_ELEMETNTS);
    }

}
