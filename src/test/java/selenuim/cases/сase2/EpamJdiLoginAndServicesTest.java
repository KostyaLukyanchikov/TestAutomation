package selenuim.cases.сase2;

import entities.User;
import enums.Header.HeaderServiceElements;
import enums.LeftSideBar.LeftSideBarServiceElements;
import enums.UIElements;
import enums.LoginUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenuim.cases.BaseTest;
import selenuim.cases.сase2.steps.AssertionSteps;
import selenuim.cases.сase2.steps.HomePageSteps;

import java.util.Arrays;
import java.util.List;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    AssertionSteps assertionSteps;
    HomePageSteps homePageSteps;


    User user = new User(LoginUser.PITER_CHAILOVSKII);


    List<String> elementsServiceFromHeaderShouldContain = Arrays.asList(
            HeaderServiceElements.SUPPORT.getHeaderServiceElement(),
            HeaderServiceElements.DATES.getHeaderServiceElement(),
            HeaderServiceElements.COMPLEX_TABLE.getHeaderServiceElement(),
            HeaderServiceElements.SIMPLE_TABLE.getHeaderServiceElement(),
            HeaderServiceElements.TABLE_WITH_PAGES.getHeaderServiceElement(),
            HeaderServiceElements.DIFFERENT_ELEMETNTS.getHeaderServiceElement());

    List<String> elementsServiceFromLeftSideBarShouldContain = Arrays.asList(
            LeftSideBarServiceElements.SUPPORT.getLeftSideBarServiceElement(),
            LeftSideBarServiceElements.DATES.getLeftSideBarServiceElement(),
            LeftSideBarServiceElements.COMPLEX_TABLE.getLeftSideBarServiceElement(),
            LeftSideBarServiceElements.SIMPLE_TABLE.getLeftSideBarServiceElement(),
            LeftSideBarServiceElements.TABLE_WITH_PAGES.getLeftSideBarServiceElement(),
            LeftSideBarServiceElements.DIFFERENT_ELEMENTS.getLeftSideBarServiceElement());

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
