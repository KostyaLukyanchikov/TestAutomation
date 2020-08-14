package page_objects;

import entities.User;
import enums.Header.HeaderElements;
import enums.Header.HeaderServiceElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    @FindBy(id = "user-icon")
    private WebElement userIconButton;

    @FindBy(id = "name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement userPasswordInputField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//ul[contains(@class,'dropdown')]/li")
    private List<WebElement> serviceHeaderDropDownMenu;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li[3]/ul//span")
    private List<WebElement> serviceLeftSideBarDropDownMenu;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(User user) {
        userIconButton.click();
        userNameInputField.sendKeys(user.getUserName());
        userPasswordInputField.sendKeys(user.getPassword());
        loginSubmitButton.click();
    }

    public void headerItemClick(HeaderElements headerElement) {
        driver.findElement(By.linkText(headerElement.getHeaderElement())).click();
    }

    public void headerOpenServiceDropDown(HeaderServiceElements headerServiceElement) {
        driver.findElement(By.linkText(headerServiceElement.getHeaderServiceElement())).click();
    }

    public List<String> grabServiceElementsFromHeader() {
        List<String> actualServiceElements = new ArrayList<>();
        serviceHeaderDropDownMenu.forEach(serviceElement -> actualServiceElements.add(serviceElement.getText()));
        return actualServiceElements;
    }

    public List<String> grabServiceElementsFromLeftSideBar() {
        List<String> actualServiceElements = new ArrayList<>();
        serviceLeftSideBarDropDownMenu.forEach(serviceElement -> actualServiceElements.add(serviceElement.getAttribute("textContent")));
        return actualServiceElements;
    }

}
