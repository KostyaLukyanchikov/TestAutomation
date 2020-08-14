package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends BasePage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
