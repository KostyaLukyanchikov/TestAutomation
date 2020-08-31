package test.selenium.case1;

import configuration.AppConfig;
import enums.Header.HeaderElements;
import enums.LoginUser;
import enums.UIElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import test.selenium.BaseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = {AppConfig.class})

public class EpamJdiSiteTest extends BaseTest {

    @Test
    public void TestEpamJdiElementsLoginAndIframe() {

        //Login and assert the Home Page
        login(LoginUser.PITER_CHAILOVSKII);

        // Assert that there are 4 items on the header section are displayed and the have proper texts
        List<String> expectedHeaderElements = HeaderElements.getHeaderElements();
        List<String> actualHeaderItems = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"))
                .stream().map(headerItem -> headerItem.getText()).collect(Collectors.toList());

        assertEquals(actualHeaderItems.size(), 4);
        assertEquals(actualHeaderItems, expectedHeaderElements);

        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = driver
                .findElements(By.xpath("//div[@class = 'benefit-icon']//span"));

        assertEquals(icons.size(), 4);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedImageTexts = UIElements.getImageTexts();
        List<String> actualImageTexts = driver.findElements(By.xpath("//span[@class = 'benefit-txt']"))
                .stream().map(imageText -> imageText.getText()).collect(Collectors.toList());;

        assertEquals(actualImageTexts, expectedImageTexts);

        //Assert a text of the main headers
        List<String> expectedMainTexts = UIElements.getBodyTexts();

        List<String> actualMainTexts = new ArrayList<>();
        WebElement mainTextEl1 = driver.findElement(By.xpath("//h3[@class='main-title text-center']"));
        actualMainTexts.add(mainTextEl1.getText());
        WebElement mainTextEl2 = driver.findElement(By.xpath("//p[@class='main-txt text-center']"));
        actualMainTexts.add(mainTextEl2.getText());
        WebElement mainTextEl3 = driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"));
        actualMainTexts.add(mainTextEl3.getText());

        assertEquals(actualMainTexts, expectedMainTexts);

        //Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.xpath("//img[@id='epam_logo']")).isDisplayed());

        driver.switchTo().defaultContent();

        //Assert that JDI GITHUB is a link and has proper URL
        assertEquals(driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"))
                .getTagName(), "a");
        assertEquals(driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"))
                .getAttribute("href"), UIElements.EPAM_JDI_URL.getUiElement());

        //Assert that there is Left Section
        //assertTrue(driver.findElement(By.xpath("div[@name = 'navigation-sidebar']")).isDisplayed());
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        //Assert that there is Footer
        assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
    }

}
