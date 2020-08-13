package Case1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Test1 extends BaseTest {

    @Test
    public void login() {
        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.xpath("//div[contains(@class, 'profile')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'name')]")).sendKeys("epam");
        driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys("1234");
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();

        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");
    }

    @Test
    public void contentTest() {
        assertEquals(driver.getTitle(), "Home Page");




        // Assert that there are 4 items on the header section are displayed and the have proper texts
        List<String> expectedHeaderElements = Arrays
                .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
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

        SoftAssert softAssert = new SoftAssert();
        for (WebElement icon : icons) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        softAssert.assertAll();




        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedImageTexts = Arrays
                .asList("To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                        "To be flexible and\n" + "customizable",
                        "To be multiplatform",
                        "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
        List<WebElement> imageTextsElements = driver.findElements(By.xpath("//span[@class = 'benefit-txt']"));
        List<String> actualImageTexts = new ArrayList<>();
        for (WebElement el : imageTextsElements) {
            actualImageTexts.add(el.getText());
        }

        assertEquals(actualImageTexts, expectedImageTexts);




        //Assert a text of the main headers
        List<String> expectedMainTexts = Arrays
                .asList("EPAM FRAMEWORK WISHES…",
                        "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
                                " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                                " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS" +
                                " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN" +
                                " REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA" +
                                " PARIATUR.",
                        "JDI GITHUB");

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
