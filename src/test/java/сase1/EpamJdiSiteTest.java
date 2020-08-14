package сase1;

import entities.User;
import enums.UIElements;
import enums.UserPiterChailovskii;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class EpamJdiSiteTest extends BaseTest {

    @Test
    public void TestEpamJdiElementsLoginAndIframe() {

        //Login and assert the Home Page

        User user = new User(
                UserPiterChailovskii.USER_CREDENTIALS.getData(),
                UserPiterChailovskii.USER_NAME.getData(),
                UserPiterChailovskii.PASSWORD.getData()
        );

        login(user);

        // Assert that there are 4 items on the header section are displayed and the have proper texts
        List<String> expectedHeaderElements = Arrays
                .asList(UIElements.HEADER_HOME.getUIelement(),
                        UIElements.HEADER_CONTACT_FORM.getUIelement(),
                        UIElements.HEADER_SERVICE.getUIelement(),
                        UIElements.HEADER_METALS_COLORS.getUIelement());

        List<String> actualHeaderItems = new ArrayList<>();

        driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"))
                .forEach(headerItem -> actualHeaderItems.add(headerItem.getText()));

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

        List<String> actualImageTexts = new ArrayList<>();

        driver.findElements(By.xpath("//span[@class = 'benefit-txt']"))
                .forEach(imageText -> actualImageTexts.add(imageText.getText()));


        assertEquals(actualImageTexts, expectedImageTexts);




        //Assert a text of the main headers
        List<String> expectedMainTexts = Arrays
                .asList(UIElements.HEADER_TEXT_1.getUIelement(),
                        UIElements.HEADER_TEXT_2.getUIelement(),
                        UIElements.HEADER_TEXT_3.getUIelement());

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



        //hz gde tam sub header




        //Assert that JDI GITHUB is a link and has proper URL
        assertEquals(driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"))
                .getTagName(), "a");
        assertEquals(driver.findElement(By.xpath("//h3[@class = 'text-center']/child::a"))
                .getAttribute("href"), UIElements.EPAM_JDI_URL.getUIelement());



        //Assert that there is Left Section
        //assertTrue(driver.findElement(By.xpath("div[@name = 'navigation-sidebar']")).isDisplayed());
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());




        //Assert that there is Footer
        assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
    }

}
