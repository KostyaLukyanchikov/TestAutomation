package org.springBddProject.qa.gui.services.pages.voids;

import org.springBddProject.qa.gui.services.enums.Header.HeaderElements;
import org.springBddProject.qa.gui.services.enums.Header.HeaderServiceElements;
import org.springBddProject.qa.gui.services.enums.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage {

    @Autowired
    @Lazy
    protected WebDriver driver;

    @FindBy(id = "user-icon")
    protected WebElement userIconButton;

    @FindBy(id = "name")
    protected WebElement userNameInputField;

    @FindBy(id = "password")
    protected WebElement userPasswordInputField;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement loginSubmitButton;

    @FindBy(xpath = "//ul[contains(@class,'dropdown')]/li")
    protected List<WebElement> serviceHeaderDropDownMenu;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li[3]/ul//span")
    protected List<WebElement> serviceLeftSideBarDropDownMenu;

    @FindBy(xpath = "//div[contains(@name, 'navigation-sidebar')]")
    protected WebElement leftSection;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(LoginUser user) {
        userIconButton.click();
        userNameInputField.sendKeys(user.getName());
        userPasswordInputField.sendKeys(user.getPassword());
        loginSubmitButton.click();
    }

    public void headerItemClick(HeaderElements headerElement) {
        driver.findElement(By.linkText(headerElement.getHeaderElement())).click();
    }

    public void headerServiceDropDownLinkClick(HeaderServiceElements headerServiceElement) {
        driver.findElement(By.linkText(headerServiceElement.getHeaderServiceElement())).click();
    }

    public List<String> grabServiceElementsFromHeader() {
        List<String> actualServiceElements = serviceHeaderDropDownMenu
                .stream()
                .map(serviceElement -> (serviceElement.getText()))
                .collect(Collectors.toList());
        return actualServiceElements;
    }

    public List<String> grabServiceElementsFromLeftSideBar() {
        List<String> actualServiceElements = serviceLeftSideBarDropDownMenu
                .stream()
                .map(serviceElement -> serviceElement.getAttribute("textContent"))
                .collect(Collectors.toList());
        return actualServiceElements;
    }

}
