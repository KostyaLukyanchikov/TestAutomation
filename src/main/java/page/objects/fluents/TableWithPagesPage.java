package page.objects.fluents;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Lists;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class TableWithPagesPage extends BasePage {

    public SelenideElement getDropDown() {
        return dropDown;
    }

    @FindBy(css = "select[name='table-with-pages_length']")
    SelenideElement dropDown;

    @FindBy(css = "input[type= 'search']")
    SelenideElement searchInput;

    @FindBy(css = "div[name = 'log-sidebar']")
    SelenideElement rightSection;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]//li")
    List<SelenideElement> logsList;

    @FindBy(xpath = "//tbody//tr")
    List<SelenideElement> searchList;

    @FindBy(xpath = "//tbody//tr//td[2]")
    List<SelenideElement> searchElementsNowSectionList;

    public int getDropDownValue() {
        return Integer.parseInt(dropDown.getValue());
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public TableWithPagesPage setDropDownValue(String value) {
        dropDown.selectOptionByValue(value);
        return this;
    }

    public TableWithPagesPage setSearchValue(String value) {
        searchInput.sendKeys(value);
        return this;
    }

    public String getDropDownLog() {
        Pattern pattern = Pattern.compile("(length).*(\\=)(\\d+)");
        List<String> logs = logsList
                .stream()
                .map(row -> pattern.matcher(row.getText()))
                .filter(Matcher::find)
                .map(row -> row.group(3))
                .collect(Collectors.toList());
        return logs.get(logs.size() - 1);
    }

    public String getSearchLog() {
        Pattern pattern = Pattern.compile("(search).*(\\=)(.*)");
        List<String> logs = logsList
                .stream()
                .map(row -> pattern.matcher(row.getText()))
                .filter(Matcher::find)
                .map(row -> row.group(3))
                .collect(Collectors.toList());
        return Lists.reverse(logs).get(logs.size() - 1);
    }

    public List<SelenideElement> getSearchList() {
        return searchList;
    }

    public List<SelenideElement> getSearchElementsNowSectionList() {
        return searchElementsNowSectionList;
    }

}
