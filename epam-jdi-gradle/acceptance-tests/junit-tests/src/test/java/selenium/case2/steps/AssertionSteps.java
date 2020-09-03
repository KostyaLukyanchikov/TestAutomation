package selenium.case2.steps;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.springBddProject.qa.gui.services.enums.LoginUser;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Component
public class AssertionSteps extends BaseSteps {

    public void browserTitleAssertion(String browserTitle) {
        assertEquals(driver.getTitle(), browserTitle);
    }


    public void userNameAssertion(LoginUser user) {
        assertEquals(driver.findElement(By.id("user-name")).getText(), user.getCredentials());
    }

    public void serviceContentAssertion(List<String> actualServiceElements,
                                        List<String> elementsServiceShouldContain) {
        assertTrue(actualServiceElements.containsAll(elementsServiceShouldContain));
    }

    public void differentElementsPageCheckBoxesNumberAssertion(int numberOfCheckBoxes) {
        assertEquals(numberOfCheckBoxes,4);
    }

    public void differentElementsPageRadioButtonsNumberAssertion(int numberOfRadioButtons) {
        assertEquals(numberOfRadioButtons,4);
    }

    public void differentElementsPageDropDownsNumberAssertion(int numberOfDropDowns) {
        assertEquals(numberOfDropDowns, 1);
    }

    public void differentElementsPageButtonsNumberAssertion(int numberOfButtons) {
        assertEquals(numberOfButtons, 2);
    }

    public void rightSectionIsVisibleAssertion() {
        assertTrue(differentElementsPage.isRightSectionVisible());
    }

    public void leftSectionIsVisibleAssertion() {
        assertTrue(differentElementsPage.isLeftSectionVisible());
    }

    public void checkBoxSelected(String checkBox) {
        assertTrue(differentElementsPage.isCheckBoxSelected(checkBox));
    }

    public void checkBoxUnSelected(String checkBox) {
        assertFalse(differentElementsPage.isCheckBoxSelected(checkBox));
    }

    public void radioButtonSelected(String radioButton) {
        assertTrue(differentElementsPage.isCheckBoxSelected(radioButton));
    }

    public void radioButtonUnSelected(String radioButton) {
        assertFalse(differentElementsPage.isCheckBoxSelected(radioButton));
    }

    public void checkLogs(List<String> elementsToCheck) {
        List<String> logs = differentElementsPage.getLogs();
        logs = Lists
                .reverse(logs)
                .subList(logs.size() - elementsToCheck.size(), logs.size());
        assertEquals(elementsToCheck, logs);
    }

    public void dropDownColorAssertion(String color) {
        assertEquals(differentElementsPage.getDropDownValue(), color);
    }

}