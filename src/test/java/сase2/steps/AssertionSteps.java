package сase2.steps;

import entities.User;
import enums.UIElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class AssertionSteps {

    private WebDriver driver;

    public AssertionSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void homePageAssertion() {
        assertEquals(driver.getTitle(), UIElements.HOME_PAGE.getUIelement());
    }

    public void userNameAssersion(User user) {
        assertEquals(driver.findElement(By.id("user-name")).getText(), user.getUserCredentials());
    }

}
