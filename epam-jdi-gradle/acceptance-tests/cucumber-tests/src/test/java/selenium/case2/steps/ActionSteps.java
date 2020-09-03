package selenium.case2.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springBddProject.qa.gui.services.enums.Header.HeaderElements;
import org.springBddProject.qa.gui.services.enums.Header.HeaderServiceElements;
import org.springBddProject.qa.gui.services.enums.LoginUser;

public class ActionSteps extends BaseSteps {
    @When("I login as {string}")
    public void iLoggingInAsUser(String user) {
        LoginUser loginUser = userNameEnum(user);
        homePage.login(loginUser);
    }

    @When("I click service button on header")
    public void iClickServiceButtonOnHeader() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
    }

    @When("I click service button on left side bar")
    public void iClickServiceButtonOnLeftSideBar() {

    }

    @And("I click different elements page button")
    public void iClickDifferentElementsPageButton() {
        homePage.headerServiceDropDownLinkClick(HeaderServiceElements.DIFFERENT_ELEMENTS);
    }

    @When("I select '([^.+]*)' checkbox")
    public void iSelectCheckboxCheckbox() {

    }

    @When("Navigate to different elements page")
    public void navigateToDifferentElementsPage() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
        homePage.headerServiceDropDownLinkClick(HeaderServiceElements.DIFFERENT_ELEMENTS);
    }
}
