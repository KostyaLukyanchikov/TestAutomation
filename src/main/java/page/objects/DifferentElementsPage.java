package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DifferentElementsPage extends BasePage {

    @FindBy(xpath = "//label[contains(@class, 'checkbox')]")
    List<WebElement> checkBoxes;

    @FindBy(xpath = "//label[contains(@class, 'radio')]")
    List<WebElement> radioButtons;

    @FindBy(xpath = "//select")
    List<WebElement> dropDowns;

    @FindBy(xpath = "//div[contains(@class, 'main-content-hg')]//button[contains(@class,'button')] | //div[contains(@class, 'main-content-hg')]//input[contains(@class,'button')]")
    List<WebElement> buttons;

    @FindBy(xpath = "//div[contains(@name, 'log-sidebar')]")
    WebElement rightSection;

    @FindBy(xpath = "//*[text()[contains(.,'Water')]]/input")
    WebElement waterCheckBox;

    @FindBy(xpath = "//*[text()[contains(.,'Wind')]]/input")
    WebElement windCheckBox;

    @FindBy(xpath = "//div[contains(@class, 'info-panel')]")
    WebElement logPanel;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
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

}
