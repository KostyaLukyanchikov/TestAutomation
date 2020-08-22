package page.objects.fluents;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.element;

public class MetalsAndColorsPage extends BasePage {

    @FindBy(css = "[class*='colors']>[class*='btn']")
    private SelenideElement colorsDropDown;

    @FindBy(xpath = "//div[@class = 'form-group metals']//span[@class = 'caret']")
    private SelenideElement metalsDropDown;

    @FindBy(css = "[class*='salad']>[type='button']")
    private SelenideElement vegetablesDropDown;

    @FindBy(css = "[id= 'submit-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[class='panel-body-list results']")
    private List<SelenideElement> resultsList;

    public MetalsAndColorsPage clickOdsRadioButton(String number) {
        element(By.xpath(String.format("//section[@id= 'odds-selector']//label[text() = '%s']", number))).click();
        return this;
    }

    public MetalsAndColorsPage clickEvenRadioButton(String number) {
        element(By.xpath(String.format("//section[@id= 'even-selector']//label[text() = '%s']", number))).click();
        return this;
    }

    public MetalsAndColorsPage clickCheckBoxes(String... checkBoxes) {
        for (String checkBox : checkBoxes) {
            element(By.xpath(String.format("//p[@class = 'checkbox']//label[text() = '%s']", checkBox))).click();
        }
        return this;
    }

    public MetalsAndColorsPage clickColorsDropDownValue(String value) {
        colorsDropDown.click();
        element(By.xpath(String.format("//div[@class = 'form-group colors']" +
                "//ul[@class='dropdown-menu inner selectpicker']" +
                "//span[text()='%s']", value))).click();
        return this;
    }

    public MetalsAndColorsPage clickMetalsDropDownValue(String value) {
        metalsDropDown.click();
        element(By.xpath(String.format("//div[@class = 'form-group metals']" +
                "//ul[@class = 'dropdown-menu inner selectpicker']" +
                "//span[text() = '%s']", value))).click();
        return this;
    }


    public MetalsAndColorsPage selectVegetablesDropDownCheckBoxes(String... checkboxes) {
        vegetablesDropDown.click();
        element(By.xpath(("//a//label[text() = 'Vegetables']"))).click();
        for (String checkBox : checkboxes) {
            element(By.xpath(String.format("//a//label[text() = '%s']", checkBox))).click();
        }
        return this;
    }

    public MetalsAndColorsPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public List<String> getResultsLog() {
        return resultsList
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

}
