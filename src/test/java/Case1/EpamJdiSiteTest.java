package Case1;

import enums.UIElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class EpamJdiSiteTest extends BaseTest {

    @Test
    public void TestEpamJdiElementsLoginAndIframe() {

        //Login and assert the Home Page
        login();

        // Assert that there are 4 items on the header section are displayed and the have proper texts
        List<String> expectedHeaderElements = Arrays
                .asList(UIElements.HOME.getUIelement(),
                        UIElements.CONTACT_FORM.getUIelement(),
                        UIElements.SERVICE.getUIelement(),
                        UIElements.METALS_COLORS.getUIelement());
        List<WebElement> headerItems = driver
                .findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"));
        List<String> actualHeaderItems = new ArrayList<>();

        for (WebElement item : headerItems) {
            actualHeaderItems.add(item.getText());
        }

        assertEquals(actualHeaderItems.size(), 4);
        assertEquals(actualHeaderItems, expectedHeaderElements);




        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = driver
                .findElements(By.xpath("//div[@class = 'benefit-icon']//span"));

        assertEquals(icons.size(), 4);



        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedImageTexts = Arrays
                .asList(UIElements.IMAGE_TEXT_1.getUIelement(),
                        UIElements.IMAGE_TEXT_2.getUIelement(),
                        UIElements.IMAGE_TEXT_3.getUIelement(),
                        UIElements.IMAGE_TEXT_4.getUIelement());

        List<WebElement> imageTextsElements = driver.findElements(By.xpath("//span[@class = 'benefit-txt']"));
        List<String> actualImageTexts = new ArrayList<>();
        for (WebElement el : imageTextsElements) {
            actualImageTexts.add(el.getText());
        }

        assertEquals(actualImageTexts, expectedImageTexts);




        //Assert a text of the main headers
        List<String> expectedMainTexts = Arrays
                .asList(UIElements.HEADER_TEXT_1.getUIelement(),
                        UIElements.HEADER_TEXT_2.getUIelement(),
                        UIElements.HEADER_TEXT_3.getUIelement());

        List<WebElement> mainTexts = new ArrayList<>();
        WebElement mainTextEl1 = driver.findElement(By.xpath("//h3[@class='main-title text-center']"));
        mainTexts.add(mainTextEl1);
        WebElement mainTextEl2 = driver.findElement(By.xpath("//p[@class='main-txt text-center']"));
        mainTexts.add(mainTextEl2);
        WebElement mainTextEl3 = driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"));
        mainTexts.add(mainTextEl3);

        List<String> actualMainTexts = new ArrayList<>();
        for (WebElement el : mainTexts) {
            actualMainTexts.add(el.getText());
        }

        assertEquals(actualMainTexts, expectedMainTexts);




        //Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.xpath("//img[@id='epam_logo']")).isDisplayed());

        driver.switchTo().defaultContent();



        //hz gde tam sub header




        //Assert that JDI GITHUB is a link and has proper URL
        assertEquals(driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"))
                .getTagName(), "a");
        assertEquals(driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"))
                .getAttribute("href"), "https://github.com/epam/JDI");




        //Assert that there is Left Section
        //assertTrue(driver.findElement(By.xpath("div[@name = 'navigation-sidebar']")).isDisplayed());
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());




        //Assert that there is Footer
        assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
    }

}
