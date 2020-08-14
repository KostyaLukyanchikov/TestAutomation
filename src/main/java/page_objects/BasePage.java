package page_objects;

import entities.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(User user) {
        userIconButton.click();
        userNameInputField.sendKeys(user.getUserName());
        userPasswordInputField.sendKeys(user.getPassword());
        loginSubmitButton.click();
    }

}
