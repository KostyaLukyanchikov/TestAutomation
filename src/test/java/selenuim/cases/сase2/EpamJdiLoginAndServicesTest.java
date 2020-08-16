package selenuim.cases.сase2;

import enums.Header.HeaderServiceElements;
import enums.LeftSideBar.LeftSideBarServiceElements;
import enums.UIElements;
import enums.LoginUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenuim.cases.BaseTest;
import selenuim.cases.сase2.steps.AssertionSteps;
import selenuim.cases.сase2.steps.HomePageSteps;

import java.util.List;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    AssertionSteps assertionSteps;
    HomePageSteps homePageSteps;

    LoginUser user = LoginUser.PITER_CHAILOVSKII;

    List<String> elementsServiceFromHeaderShouldContain = HeaderServiceElements
            .getElementsServiceFromHeaderShouldContain();

    List<String> elementsServiceFromLeftSideBarShouldContain = LeftSideBarServiceElements
            .getElementsServiceFromLeftSideBarShouldContain();

    @Override
    @BeforeMethod
    public void setUpBrowser() {
        super.setUpBrowser();
        assertionSteps = new AssertionSteps(driver);
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void loginTest() {

        assertionSteps.browserTitleAssertion(UIElements.HOME_PAGE.getUiElement());

        homePageSteps.loginAsUser(user);
        assertionSteps.userNameAssertion(user);

    }

    @Test
    public void serviceFromHeaderContentTest() {

        homePageSteps.loginAsUser(user);
        assertionSteps.userNameAssertion(user);

        homePageSteps.openServiceDropDownMenuFromHeader();
        List<String> actualHeaderServiceElements = homePageSteps.getServiceElementsFromHeader();
        assertionSteps.serviceContentAssertion(actualHeaderServiceElements, elementsServiceFromHeaderShouldContain);

    }

    @Test
    public void serviceFromLeftSideBarContentTest() {

        homePageSteps.loginAsUser(user);
        assertionSteps.userNameAssertion(user);

        homePageSteps.openServiceDropDownMenuFromLeftSideBar();
        List<String> actualLeftSideBarServiceElements = homePageSteps.getServiceElementsFromLeftSideBar();
        assertionSteps.serviceContentAssertion(actualLeftSideBarServiceElements, elementsServiceFromLeftSideBarShouldContain);

    }

}
