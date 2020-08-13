package Case1;

import enums.Assertions;
import enums.UIElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;

import static org.testng.Assert.assertEquals;


public abstract class BaseTest {

    protected WebDriver driver;
    String epamUrl = PropertyReader.getInstance().getUrl();
    String epamUserName = PropertyReader.getInstance().getUserName();
    String epamPassword = PropertyReader.getInstance().getPassword();

    @BeforeSuite
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.get(epamUrl);
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

    protected void login() {
        homePageAssertion();

        driver.findElement(By.xpath("//div[contains(@class, 'profile')]")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'name')]")).sendKeys(epamUserName);
        driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys(epamPassword);
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();

        userNameAssersion();
    }

    //Common Assertions
    public void homePageAssertion() {
        assertEquals(driver.getTitle(), Assertions.HOME_PAGE.getAssertion());
    }

    public void userNameAssersion() {
        assertEquals(driver.findElement(By.id("user-name")).getText(), Assertions.USER_NAME.getAssertion());
    }

}
