package selenuim.cases.сase2.steps;

import entities.User;
import enums.Header.HeaderElements;
import enums.Header.HeaderServiceElements;
import enums.LoginUser;
import org.openqa.selenium.WebDriver;
import page.objects.HomePage;

import java.util.List;

public class ActionSteps {

    private WebDriver driver;
    private HomePage homePage;

    public ActionSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }


    public void loginAsUser(LoginUser loginUser) {

        User user = new User(loginUser);

        homePage.login(user);
    }


    public void openServiceDropDownMenuFromHeader() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
    }

    public void openServiceDropDownMenuFromLeftSideBar() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
    }

    public void navigateToDifferentElementsPage() {
        homePage.headerOpenServiceDropDown(HeaderServiceElements.DIFFERENT_ELEMENTS);
    }

    public List<String> getServiceElementsFromHeader() {
        return homePage.grabServiceElementsFromHeader();
    }

    public List<String> getServiceElementsFromLeftSideBar() {
        return homePage.grabServiceElementsFromLeftSideBar();
    }

}
