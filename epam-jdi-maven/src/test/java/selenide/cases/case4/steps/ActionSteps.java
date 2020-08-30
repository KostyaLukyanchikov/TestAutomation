package selenide.cases.case4.steps;

import entities.MetalsAndColorsForm;
import enums.LoginUser;

import java.util.List;

public class ActionSteps extends BaseSteps {

    public void loginAsUser(LoginUser loginUser) {
        homePage.login(loginUser);
    }

    public void navigateToMetalsAndColorsPage() {
        metalsAndColorsPage = homePage.headerMetalsAndColorsClick();
    }

    public void selectRadioButtons(String oddNumber, String evenNumber) {
        metalsAndColorsPage
                .clickOdsRadioButton(oddNumber)
                .clickEvenRadioButton(evenNumber);
    }

    public void selectCheckBoxes(String... checkBoxes) {
        metalsAndColorsPage.clickCheckBoxes(checkBoxes);
    }

    public void selectColorsDropDownValue(String value) {
        metalsAndColorsPage.clickColorsDropDownValue(value);
    }

    public void selectMetalsDropDownValue(String value) {
        metalsAndColorsPage.clickMetalsDropDownValue(value);
    }

    public void selectVegetablesCheckBoxes(String... checkboxes) {
        metalsAndColorsPage.selectVegetablesDropDownCheckBoxes(checkboxes);
    }

    public void submitMetalsAndColorsForm() {
        metalsAndColorsPage.clickSubmitButton();
    }

    public void fillTheForm(MetalsAndColorsForm form) {
        selectRadioButtons(form.getOddRadioButton(), form.getEvenRadioButton());
        if (!(form.getElementsCheckBoxes() == (null))) {
            selectCheckBoxes(form.getElementsCheckBoxes());
        }
        selectColorsDropDownValue(form.getColorsDropDownValue());
        selectMetalsDropDownValue(form.getMetalsDropDownValue());
        selectVegetablesCheckBoxes(form.getVegetablesDropDownCheckBoxes());
    }

    public List<String> getActualResults() {
        return metalsAndColorsPage.getResultsLog();
    }

}
