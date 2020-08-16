package selenuim.cases.сase2;

import enums.Header.HeaderServiceElements;
import enums.LeftSideBar.LeftSideBarServiceElements;
import enums.LoginUser;
import enums.UIElements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenuim.cases.BaseTest;
import selenuim.cases.сase2.steps.ActionSteps;
import selenuim.cases.сase2.steps.AssertionSteps;

import java.util.List;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    AssertionSteps assertionSteps;
    ActionSteps actionSteps;

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
        actionSteps = new ActionSteps(driver);
    }

    @Test
    public void loginTest() {

        assertionSteps.browserTitleAssertion(UIElements.HOME_PAGE.getUiElement());

        actionSteps.loginAsUser(user);
        assertionSteps.userNameAssertion(user);

    }

    @Test
    public void serviceFromHeaderContentTest() {

        actionSteps.loginAsUser(user);
        assertionSteps.userNameAssertion(user);

        actionSteps.openServiceDropDownMenuFromHeader();
        List<String> actualHeaderServiceElements = actionSteps.getServiceElementsFromHeader();
        assertionSteps.serviceContentAssertion(actualHeaderServiceElements, elementsServiceFromHeaderShouldContain);

    }

    @Test
    public void serviceFromLeftSideBarContentTest() {

        actionSteps.loginAsUser(user);
        assertionSteps.userNameAssertion(user);

        actionSteps.openServiceDropDownMenuFromLeftSideBar();
        List<String> actualLeftSideBarServiceElements = actionSteps.getServiceElementsFromLeftSideBar();
        assertionSteps.serviceContentAssertion(actualLeftSideBarServiceElements, elementsServiceFromLeftSideBarShouldContain);

    }

}
