package selenuim.cases.сase2.steps;

import com.google.common.collect.Lists;
import enums.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.objects.DifferentElementsPage;
import page.objects.HomePage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseSteps {

    public AssertionSteps(WebDriver driver) {
        super(driver);
    }

    public void browserTitleAssertion(String browserTitle) {
        System.out.println(driver.getCurrentUrl());
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

    public void radioButtonSelected(String radioButton) {
        assertTrue(differentElementsPage.isCheckBoxSelected(radioButton));
    }

    public void checkLogs(List<String> elementsToCheck) {
        List<String> logs = differentElementsPage.getLogs();
        logs = Lists
                .reverse(logs)
                .subList(logs.size() - elementsToCheck.size(), logs.size());
        assertEquals(elementsToCheck, logs);
    }

}
