package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DifferentElementsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'checkbox')]//label[contains(@class, 'checkbox')]")
    List<WebElement> checkBoxes;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> grabCheckBoxes() {
        return checkBoxes.stream().collect(Collectors.toList());
    }

}
