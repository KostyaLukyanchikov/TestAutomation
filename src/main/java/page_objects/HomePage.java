package page_objects;

import enums.Header.HeaderElements;
import enums.Header.HeaderServiceElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private WebElement headerItemButton;

    private WebElement servicesDropDownButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void headerItemClick(HeaderElements headerElement) {
        driver.findElement(By.linkText(headerElement.getHeaderElement())).click();
    }

    public void headerOpenServiceDropDown(HeaderServiceElements headerServiceElement) {
        driver.findElement(By.linkText(headerServiceElement.getHeaderServiceElement())).click();
    }

}
