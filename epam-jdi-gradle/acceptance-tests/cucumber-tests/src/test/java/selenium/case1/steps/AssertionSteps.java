package selenium.case1.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.springBddProject.qa.gui.services.enums.LoginUser;

import static org.junit.Assert.assertEquals;

public class AssertionSteps extends BaseSteps {
    @Then("My personal account name shows")
    public void nameShows(){
        assertEquals(driver.findElement(By.id("user-name")).getText(), LoginUser.PITER_CHAILOVSKII.getCredentials());
    }

}
