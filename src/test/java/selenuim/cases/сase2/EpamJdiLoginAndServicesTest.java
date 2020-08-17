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

import java.util.Arrays;
import java.util.List;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    AssertionSteps assertionSteps;
    ActionSteps actionSteps;

    LoginUser loginUser = LoginUser.PITER_CHAILOVSKII;

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

        actionSteps.loginAsUser(loginUser);
        assertionSteps.userNameAssertion(loginUser);

    }

    @Test
    public void serviceFromHeaderContentTest() {

        actionSteps.loginAsUser(loginUser);
        assertionSteps.userNameAssertion(loginUser);

        actionSteps.openServiceDropDownMenuFromHeader();
        List<String> actualHeaderServiceElements = actionSteps.getServiceElementsFromHeader();

        assertionSteps.serviceContentAssertion(
                actualHeaderServiceElements,
                elementsServiceFromHeaderShouldContain);

    }

    @Test
    public void serviceFromLeftSideBarContentTest() {

        actionSteps.loginAsUser(loginUser);
        assertionSteps.userNameAssertion(loginUser);

        actionSteps.openServiceDropDownMenuFromLeftSideBar();
        List<String> actualLeftSideBarServiceElements = actionSteps.getServiceElementsFromLeftSideBar();

        assertionSteps.serviceContentAssertion(
                actualLeftSideBarServiceElements,
                elementsServiceFromLeftSideBarShouldContain);

    }

    @Test
    public void serviceDifferentElementsPageTest() {

        actionSteps.loginAsUser(loginUser);
        assertionSteps.userNameAssertion(loginUser);

        actionSteps.navigateToDifferentElementsPage();

        int numberOfCheckBoxes = actionSteps.getTheNumberOfCheckBoxesOnDifferentElementsPage();
        assertionSteps.differentElementsPageCheckBoxesNumberAssertion(numberOfCheckBoxes);

        int numberOfRadioButtons = actionSteps.getTheNumberOfRadioButtonsOnDifferentElementsPage();
        assertionSteps.differentElementsPageRadioButtonsNumberAssertion(numberOfRadioButtons);

        int numberOfDropDowns = actionSteps.getTheNumberOfDropDowns();
        assertionSteps.differentElementsPageDropDownsNumberAssertion(numberOfDropDowns);

        int numberOfButtons = actionSteps.getTheNumberOfButtons();
        assertionSteps.differentElementsPageButtonsNumberAssertion(numberOfButtons);

        assertionSteps.rightSectionIsVisibleAssertion();
        assertionSteps.leftSectionIsVisibleAssertion();

        actionSteps.selectCheckBox("Water");
        actionSteps.selectCheckBox("Wind");
        assertionSteps.checkBoxSelected("Water");
        assertionSteps.checkBoxSelected("Wind");

        assertionSteps.checkLogs(Arrays.asList("Water", "Wind"));
    }

}
