package selenium.case2.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springBddProject.qa.gui.services.enums.Header.HeaderServiceElements;
import org.springBddProject.qa.gui.services.enums.LoginUser;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionSteps extends BaseSteps {


    @Then("My personal account name shows")
    public void nameShows(){
        assertEquals(homePage.getUserNameShown(), LoginUser.PITER_CHAILOVSKII.getCredentials());
    }

    @Then("Service drop down elements *elements* should be displayed")
    public void serviceDropDownElementsElementsShouldBeDisplayed(List<String> elementsServiceShouldContain) {
        List<String> actualServiceElements = getServiceElementsFromLeftSideBar();
        assertTrue(actualServiceElements.containsAll(elementsServiceShouldContain));
    }

    @And("Header service dropdown shows")
    public void headerServiceDropdownShows() {
        assertTrue(homePage.isHeaderServiceDropDownDisplayed());
    }

    @And("Different elements page opens")
    public void iNavigateToDifferentElementsPage() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlToBe(diffElPageUrl));
        assertEquals(driver.getCurrentUrl(), diffElPageUrl);

    }

    @Then("Header service drop down elements should be displayed")
    public void headerServiceDropDownElementsElementsShouldBeDisplayed(List<String> expectedElements) {
        List<String> actualElements = HeaderServiceElements.getElementsServiceFromHeaderShouldContain();
        assertTrue(actualElements.containsAll(expectedElements));
    }

    @Then("^Number check boxes should be ([\\d])$")
    public void numberCheckBoxesShouldBeNumber(int number) {
        assertEquals(getTheNumberOfCheckBoxesOnDifferentElementsPage(), number);
    }

    @Then("^Number radio buttons should be ([\\d])$")
    public void numberRadioButtonsShouldBe(int number) {
        assertEquals(getTheNumberOfRadioButtonsOnDifferentElementsPage(), number);
    }

    @Then("^Number drop downs should be ([\\d])$")
    public void numberDropDownsShouldBe(int number) {
        assertEquals(getTheNumberOfDropDowns(), number);
    }

    @Then("^Number buttons should be ([\\d])$")
    public void numberButtonsShouldBe(int number) {
        assertEquals(getTheNumberOfButtons(), number);
    }

}
