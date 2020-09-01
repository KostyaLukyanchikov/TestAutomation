package selenium.case2.steps;


import org.openqa.selenium.WebDriver;
import org.springBddProject.qa.gui.services.enums.Header.HeaderElements;
import org.springBddProject.qa.gui.services.enums.Header.HeaderServiceElements;
import org.springBddProject.qa.gui.services.enums.LoginUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionSteps extends BaseSteps {

    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    public void loginAsUser(LoginUser loginUser) {
        homePage.login(loginUser);
    }

    public void openServiceDropDownMenuFromHeader() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
    }

    public void openServiceDropDownMenuFromLeftSideBar() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
    }

    public void navigateToDifferentElementsPage() {
        homePage.headerItemClick(HeaderElements.HEADER_SERVICE);
        homePage.headerServiceDropDownLinkClick(HeaderServiceElements.DIFFERENT_ELEMENTS);
    }

    public List<String> getServiceElementsFromHeader() {
        return homePage.grabServiceElementsFromHeader();
    }

    public List<String> getServiceElementsFromLeftSideBar() {
        return homePage.grabServiceElementsFromLeftSideBar();
    }

    public int getTheNumberOfCheckBoxesOnDifferentElementsPage() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getCheckBoxes()).size();
    }
    public int getTheNumberOfRadioButtonsOnDifferentElementsPage() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getRadioButtons()).size();
    }

    public int getTheNumberOfDropDowns() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getDropDowns()).size();
    }

    public int getTheNumberOfButtons() {
        return differentElementsPage.grabNumberOfElements(differentElementsPage.getButtons()).size();
    }

    public void selectCheckBox(String checkBox) {
        differentElementsPage.clickOnCheckBox(checkBox);
    }

    public void selectRadioButton(String radioButton) {
        differentElementsPage.clickOnCheckBox(radioButton);
    }

    public void selectDropDownColor(String color) {
        differentElementsPage.selectDropDownValue(color);
    }

}
