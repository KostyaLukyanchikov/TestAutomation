package selenuim.cases.сase2.steps;

import enums.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps {

    private WebDriver driver;

    public AssertionSteps(WebDriver driver) {
        this.driver = driver;
    }

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

}
