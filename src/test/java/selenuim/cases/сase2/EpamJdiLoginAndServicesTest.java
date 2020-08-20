package selenuim.cases.сase2;

import enums.Header.HeaderServiceElements;
import enums.LeftSideBar.LeftSideBarServiceElements;
import enums.LoginUser;
import enums.Logs;
import enums.UIElements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenuim.cases.BaseTest;
import selenuim.cases.сase2.steps.ActionSteps;
import selenuim.cases.сase2.steps.AssertionSteps;

import java.util.*;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    private AssertionSteps assertionSteps;
    private ActionSteps actionSteps;

    private LoginUser loginUser = LoginUser.PITER_CHAILOVSKII;

    private List<String> elementsServiceFromHeaderShouldContain = HeaderServiceElements
            .getElementsServiceFromHeaderShouldContain();

    private List<String> elementsServiceFromLeftSideBarShouldContain = LeftSideBarServiceElements
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

        //Login
        actionSteps.loginAsUser(loginUser);
        assertionSteps.userNameAssertion(loginUser);

        //Navigate to different elements page
        actionSteps.navigateToDifferentElementsPage();

        //Assert number of elements on the page
        int numberOfCheckBoxes = actionSteps.getTheNumberOfCheckBoxesOnDifferentElementsPage();
        assertionSteps.differentElementsPageCheckBoxesNumberAssertion(numberOfCheckBoxes);

        int numberOfRadioButtons = actionSteps.getTheNumberOfRadioButtonsOnDifferentElementsPage();
        assertionSteps.differentElementsPageRadioButtonsNumberAssertion(numberOfRadioButtons);

        int numberOfDropDowns = actionSteps.getTheNumberOfDropDowns();
        assertionSteps.differentElementsPageDropDownsNumberAssertion(numberOfDropDowns);

        int numberOfButtons = actionSteps.getTheNumberOfButtons();
        assertionSteps.differentElementsPageButtonsNumberAssertion(numberOfButtons);

        //Assert right and left section
        assertionSteps.rightSectionIsVisibleAssertion();
        assertionSteps.leftSectionIsVisibleAssertion();

        //Select checkboxes and assert logs changed
        actionSteps.selectCheckBox("Water");
        actionSteps.selectCheckBox("Wind");
        assertionSteps.checkBoxSelected("Water");
        assertionSteps.checkBoxSelected("Wind");
        assertionSteps.checkLogs(Arrays.asList(
                Logs.WATER_BOX_ON.getButtonState(),
                Logs.WIND_BOX_ON.getButtonState()));

        //Select radio button and assert logs changed
        actionSteps.selectRadioButton("Selen");
        assertionSteps.radioButtonSelected("Selen");
        assertionSteps.checkLogs(Collections.singletonList(Logs.SELEN_RADIO_ON.getButtonState()));

        //Select drop down and assert logs changed
        actionSteps.selectDropDownColor("Yellow");
        assertionSteps.dropDownColorAssertion("Yellow");
        assertionSteps.checkLogs(Collections.singletonList(Logs.YELLOW_DROP_DOWN_ON.getButtonState()));

        //Unselect checkboxes and assert logs changed
        actionSteps.selectCheckBox("Water");
        actionSteps.selectCheckBox("Wind");
        assertionSteps.checkBoxUnSelected("Water");
        assertionSteps.checkBoxUnSelected("Wind");
        assertionSteps.checkLogs(Arrays.asList(
                Logs.WATER_BOX_OFF.getButtonState(),
                Logs.WIND_BOX_OFF.getButtonState()));

    }

}
