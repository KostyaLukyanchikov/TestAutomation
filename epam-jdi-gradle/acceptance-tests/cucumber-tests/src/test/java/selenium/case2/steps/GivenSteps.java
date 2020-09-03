package selenium.case2.steps;

import io.cucumber.java.en.Given;

public class GivenSteps extends BaseSteps {

    @Given("I open epam index page")
    public void iOpenHomePage() {
        homePage.open();
    }

    @Given("I am on any page on Epam Jdi")
    public void iAmOnAnyPageOnEpamJdi() {
        homePage.open();
    }

    @Given("I am on different elements page")
    public void iAmOnDifferentElementsPage() {
        driver.get(diffElPageUrl);
        System.out.println(driver.getTitle());
    }
}
