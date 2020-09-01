package org.springBddProject.qa.gui.services.pages.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springBddProject.qa.gui.annotations.PageObject;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@PageObject
public class DifferentElementsPage extends BasePage {

    @FindBy(xpath = "//label[contains(@class, 'checkbox')]")
    List<WebElement> checkBoxes;

    @FindBy(xpath = "//label[contains(@class, 'radio')]")
    List<WebElement> radioButtons;

    @FindBy(xpath = "//select")
    List<WebElement> dropDowns;

    @FindBy(xpath = "//select[contains(@class, 'form')]")
    WebElement dropDownColor;

    @FindBy(xpath = "//div[contains(@class, 'main-content-hg')]//button[contains(@class,'button')] | //div[contains(@class, 'main-content-hg')]//input[contains(@class,'button')]")
    List<WebElement> buttons;

    @FindBy(xpath = "//div[contains(@name, 'log-sidebar')]")
    WebElement rightSection;

    @FindBy(xpath = "//*[text()[contains(.,'Water')]]/input")
    WebElement waterCheckBox;

    @FindBy(xpath = "//*[text()[contains(.,'Wind')]]/input")
    WebElement windCheckBox;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]//li")
    List<WebElement> logsList;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> grabNumberOfElements(List<WebElement> webElementsList) {
        return webElementsList.stream().collect(Collectors.toList());
    }

    public boolean isRightSectionVisible() {
        return rightSection.isDisplayed();
    }

    public boolean isLeftSectionVisible() {
        return leftSection.isDisplayed();
    }

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }

    public List<WebElement> getDropDowns() {
        return dropDowns;
    }

    public List<WebElement> getButtons() {
        return buttons;
    }

    public void clickOnCheckBox(String checkBoxName) {
        driver.findElement(By.xpath(String.format("//*[text()[contains(.,'%s')]]/input", checkBoxName))).click();
    }

    public boolean isCheckBoxSelected(String checkBoxName) {
        return driver.findElement(By.xpath(String.format("//*[text()[contains(.,'%s')]]/input", checkBoxName))).isSelected();
    }

    public void clickOnRadioButton(String radioButtonName) {
        driver.findElement(By.xpath(String.format("//*[text()[contains(.,'%s')]]/input", radioButtonName))).click();
    }

    public boolean isRadioButtonSelected(String radioButtonName) {
        return driver.findElement(By.xpath(String.format("//*[text()[contains(.,'%s')]]/input", radioButtonName))).isSelected();
    }

    public List<String> getLogs() {
        Pattern pattern = Pattern.compile("([a-zA-Z].*)");
        return logsList
                .stream()
                .map(row -> pattern.matcher(row.getText()))
                .filter(Matcher::find)
                .map(Matcher::group)
                .collect(Collectors.toList());
    }

    public void selectDropDownValue(String color) {
        new Select(dropDownColor).selectByVisibleText(color);
    }

    public String getDropDownValue() {
        return new Select(dropDownColor).getFirstSelectedOption().getText();
    }

}