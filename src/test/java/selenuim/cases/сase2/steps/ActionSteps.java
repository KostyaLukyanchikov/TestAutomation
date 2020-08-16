package selenuim.cases.сase2.steps;

import entities.User;
import enums.Header.HeaderElements;
import enums.Header.HeaderServiceElements;
import enums.LoginUser;
import org.openqa.selenium.WebDriver;
import page.objects.BasePage;
import page.objects.DifferentElementsPage;
import page.objects.HomePage;

import java.util.List;

public class ActionSteps extends BaseSteps {

    public ActionSteps(WebDriver driver) {
        super(driver);
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
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
        homePage.headerServiceDropDownLinkClick(HeaderServiceElements.DIFFERENT_ELEMENTS);
    }

    public List<String> getServiceElementsFromHeader() {
        return homePage.grabServiceElementsFromHeader();
    }

    public List<String> getServiceElementsFromLeftSideBar() {
        return homePage.grabServiceElementsFromLeftSideBar();
    }

    public int getTheNumberOfCheckBoxesOnDifferentElementsPage() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getCheckBoxes()).size();
    }
    public int getTheNumberOfRadioButtonsOnDifferentElementsPage() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getRadioButtons()).size();
    }

    public int getTheNumberOfDropDowns() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getDropDowns()).size();
    }

    public int getTheNumberOfButtons() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getButtons()).size();
    }

}
