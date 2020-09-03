package selenium.case2;


import configuration.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springBddProject.qa.gui.services.enums.Header.HeaderServiceElements;
import org.springBddProject.qa.gui.services.enums.LeftSideBar.LeftSideBarServiceElements;
import org.springBddProject.qa.gui.services.enums.LoginUser;
import org.springBddProject.qa.gui.services.enums.Logs;
import org.springBddProject.qa.gui.services.enums.UIElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import selenium.BaseTest;
import selenium.case2.steps.ActionSteps;
import selenium.case2.steps.AssertionSteps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
public class EpamJdiLoginAndServiceDifferentElementsTest extends BaseTest {

    @Autowired
    @Lazy
    AssertionSteps assertionSteps;

    @Autowired
    @Lazy
    ActionSteps actionSteps;

    LoginUser loginUser = LoginUser.PITER_CHAILOVSKII;

    List<String> elementsServiceFromHeaderShouldContain = HeaderServiceElements
            .getElementsServiceFromHeaderShouldContain();

    List<String> elementsServiceFromLeftSideBarShouldContain = LeftSideBarServiceElements
            .getElementsServiceFromLeftSideBarShouldContain();


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