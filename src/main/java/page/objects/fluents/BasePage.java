package page.objects.fluents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import enums.Header.HeaderElements;
import enums.Header.HeaderServiceElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.page;

public abstract class BasePage {

    @FindBy(id = "user-icon")
    protected SelenideElement userIconButton;

    @FindBy(id = "name")
    protected SelenideElement userNameInputField;

    @FindBy(id = "password")
    protected SelenideElement userPasswordInputField;

    @FindBy(xpath = "//button[@type='submit']")
    protected SelenideElement loginSubmitButton;

    @FindBy(xpath = "//*[@class = 'dropdown-menu']/li")
    protected List<SelenideElement> serviceHeaderDropDownMenu;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul/li[3]/ul//span")
    protected List<SelenideElement> serviceLeftSideBarDropDownMenu;

    @FindBy(xpath = "//div[contains(@name, 'navigation-sidebar')]")
    protected SelenideElement leftSection;

    public BasePage() {
        page(this);
    }

    public BasePage refresh() {
        Selenide.refresh();
        return this;
    }

    public TableWithPagesPage headerServiceTableWithPagesClick() {
        headerItemClick(HeaderElements.HEADER_SERVICE);
        element(By.linkText(HeaderServiceElements.TABLE_WITH_PAGES.getHeaderServiceElement())).click();
        return new TableWithPagesPage();
    }

    public BasePage headerItemClick(HeaderElements headerElement) {
        element(By.linkText(headerElement.getHeaderElement())).click();
        return this;
    }

    public List<String> grabServiceElementsFromHeader() {
        element(By.linkText(HeaderElements.HEADER_SERVICE.getHeaderElement())).click();

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
