package selenium.case1.steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.springBddProject.qa.gui.services.enums.LoginUser;

public class ActionSteps extends BaseSteps {
    @When("I login as user")
    public void iLoggingInAsUser() {
        driver.findElement(By.xpath("//div[contains(@class, 'profile')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'name')]")).sendKeys(LoginUser.PITER_CHAILOVSKII.getName());
        driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys(LoginUser.PITER_CHAILOVSKII.getPassword());
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();
    }
}
