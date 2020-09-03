package selenium.case1.steps;

import io.cucumber.java.en.Given;

public class GivenSteps extends BaseSteps {
    @Given("I open index page")
    public void iOpenHomePage() {
        driver.get(epamUrl);
    }
}
