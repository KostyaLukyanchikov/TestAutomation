package сase2.steps;

import entities.User;
import enums.UIElements;
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

    public void userNameAssertion(User user) {
        assertEquals(driver.findElement(By.id("user-name")).getText(), user.getUserCredentials());
    }

    public void headerServiceAssertion(List<String> actualServiceElements,
                                       List<String> elementsServiceShouldContain) {
        System.out.println(actualServiceElements.toString() + actualServiceElements.size());
        System.out.println(elementsServiceShouldContain.toString() + elementsServiceShouldContain.size());
        assertTrue(actualServiceElements.containsAll(elementsServiceShouldContain));
    }

}
